package com.example.oauth2.oauth2common.parameters;

import com.example.oauth2.oauth2common.exception.OAuthSystemException;
import com.example.oauth2.oauth2common.message.OAuthMessage;
import com.example.oauth2.oauth2common.utils.OAuthUtils;
import java.util.Map;


public class BodyURLEncodedParametersApplier implements OAuthParametersApplier {

    public OAuthMessage applyOAuthParameters(OAuthMessage message, Map<String, String> params)
        throws OAuthSystemException {

        String body = OAuthUtils.format(params.entrySet(), "UTF-8");
        message.setBody(body);
        return message;

    }
}
