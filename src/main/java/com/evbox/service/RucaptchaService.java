package com.evbox.service;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;

import com.evbox.logger.Logger;
import com.evbox.test.BaseTest;
import com.evbox.util.HttpClientUtil;

public class RucaptchaService implements CaptchaService {

    private static final Logger LOGGER = new Logger(BaseTest.class);

    private static final String GOOGLE_KEY = "6Lc2_RsUAAAAAAYBSd4rxsgeQz7whuL9COCsHeET";
    private static final String SEND_CAPTCHA_URL_PATTERN = "https://rucaptcha.com/in.php?key=%s&method=userrecaptcha&googlekey=%s"
            + "&pageurl=%s";
    private static final String GET_TOKEN_URL_PATTERN = "http://rucaptcha.com/res.php?key=%s&action=get&id=%s";

    private static final String CAPCHA_NOT_READY_RESPONSE = "CAPCHA_NOT_READY";
    // user's key
    private static String apiKey;

    public RucaptchaService(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String generateToken(String pageUrl) {
        // get captcha id from rucaptcha api
        String sendCaptchaRequestUrl = generateSendCaptchaUrl(apiKey, pageUrl);
        String captchaIdResponse = HttpClientUtil.getRequest(sendCaptchaRequestUrl);
        String captchaId = extractResponsePayload(captchaIdResponse);

        // get token from rucaptcha api by id
        String getTokenUrl = generateGetCaptchaTokenUrl(apiKey, captchaId);
        String tokenResponse = waitAndGetTokenProvided(getTokenUrl);
        return extractResponsePayload(tokenResponse);
    }

    private String waitAndGetTokenProvided(String getTokenUrl) {
        LOGGER.debug("Wait for token provided from service.");
        String tokenResponse = HttpClientUtil.getRequest(getTokenUrl);
        FluentWait<String> wait = new FluentWait<>(getTokenUrl)
                .withTimeout(Duration.ofSeconds(180))
                .pollingEvery(Duration.ofSeconds(10));
        return wait.until(new Function<String, String>() {

            public String apply(String requestUrl) {
                String tokenResponse = HttpClientUtil.getRequest(getTokenUrl);
                LOGGER.debug("Rucaptcha response: " + tokenResponse);
                if (!tokenResponse.equals(CAPCHA_NOT_READY_RESPONSE)) {
                    return tokenResponse;
                } else {
                    return null;
                }

            }
        });
    }

    private String extractResponsePayload(String response) {
        //TODO groups
        return response.substring(3);
    }

    private String generateSendCaptchaUrl(String apiKey, String pageUrl) {
        return String.format(SEND_CAPTCHA_URL_PATTERN, apiKey, GOOGLE_KEY, pageUrl);
    }

    private String generateGetCaptchaTokenUrl(String apiKey, String captchaId) {
        return String.format(GET_TOKEN_URL_PATTERN, apiKey, captchaId);
    }
}
