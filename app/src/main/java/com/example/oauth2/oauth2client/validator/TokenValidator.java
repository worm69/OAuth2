package com.example.oauth2.oauth2client.validator;

import com.example.oauth2.oauth2common.OAuth;

public class TokenValidator extends OAuthClientValidator {

    public TokenValidator() {

        requiredParams.put(OAuth.OAUTH_ACCESS_TOKEN, new String[] {});

        notAllowedParams.add(OAuth.OAUTH_CODE);
    }
}
