package com.evbox.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.evbox.logger.Logger;

public final class HttpClientUtil {

    private static final Logger LOGGER = new Logger(HttpClientUtil.class);

    private HttpClientUtil() {
        // private constructor for util class
    }

    public static String getRequest(String requestUrl) {
        LOGGER.debug("Send request: " + requestUrl);
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpResponse response = client.execute(new HttpGet(requestUrl));
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException("Failure during executing GET request.", e);
        }
    }
}
