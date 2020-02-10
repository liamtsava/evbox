package com.evbox.report;

import com.evbox.logger.Logger;

import io.qameta.allure.Attachment;

public final class ReportAttachment {

    private static final Logger LOGGER = new Logger(ReportAttachment.class);

    private ReportAttachment() {
        // private constructor for util class
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }

}