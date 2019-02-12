package com.example.oauth2.oauth2client.response;


import com.example.oauth2.oauth2common.OAuth;
import com.example.oauth2.oauth2common.utils.OAuthUtils;

public class GitHubTokenResponse extends OAuthAccessTokenResponse {


    public String getAccessToken() {
        return parameters.get(OAuth.OAUTH_ACCESS_TOKEN);
    }

    public String getExpiresIn() {
        return parameters.get(OAuth.OAUTH_EXPIRES_IN);
    }

    public String getRefreshToken() {
        return parameters.get(OAuth.OAUTH_EXPIRES_IN);
    }

    public String getScope() {
        return parameters.get(OAuth.OAUTH_SCOPE);
    }

    protected void setBody(String body) {
        this.body = body;
        parameters = OAuthUtils.decodeForm(body);
    }

    protected void setContentType(String contentType) {
        this.contentType = contentType;
    }

    protected void setResponseCode(int code) {
        this.responseCode = code;
    }

    public String getParam(String name) {
        return parameters.get(name);
    }

}
