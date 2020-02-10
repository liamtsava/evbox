package com.evbox.logger;

import org.slf4j.LoggerFactory;

import io.qameta.allure.Allure;

/**
 * Logger integrated with Allure report
 */
public class Logger {

    private org.slf4j.Logger logger;

    public Logger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String message) {
        Allure.step(message);
        logger.info(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void error(String message, Throwable e) {
        logger.error(message, e);
    }
}