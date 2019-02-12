package com.example.oauth2.oauth2common.message.types;

public enum GrantType {
    AUTHORIZATION_CODE("authorization_code"),
    PASSWORD("password"),
    ASSERTION("assertion"),
    REFRESH_TOKEN("refresh_token"),
    NONE("none");

    private String grantType;

    GrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString() {
        return grantType;
    }
}
