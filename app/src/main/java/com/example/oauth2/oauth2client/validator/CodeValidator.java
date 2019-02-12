package com.example.oauth2.oauth2client.validator;

import com.example.oauth2.oauth2common.OAuth;

public class CodeValidator extends OAuthClientValidator {

    public CodeValidator() {

        requiredParams.put(OAuth.OAUTH_CODE, new String[] {});

        notAllowedParams.add(OAuth.OAUTH_ACCESS_TOKEN);
        notAllowedParams.add(OAuth.OAUTH_EXPIRES_IN);
    }
}
