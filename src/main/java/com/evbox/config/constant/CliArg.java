package com.evbox.config.constant;

public enum CliArg {

    BROWSER_TYPE("browserType");

    private String name;

    CliArg(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
