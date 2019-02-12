package com.example.oauth2.oauth2client.validator;

import com.example.oauth2.oauth2common.OAuth;

public class CodeTokenValidator extends OAuthClientValidator {

    public CodeTokenValidator() {
        requiredParams.put(OAuth.OAUTH_CODE, new String[] {});
        requiredParams.put(OAuth.OAUTH_ACCESS_TOKEN, new String[] {});

        notAllowedParams.add(OAuth.OAUTH_ACCESS_TOKEN);
    }
}
