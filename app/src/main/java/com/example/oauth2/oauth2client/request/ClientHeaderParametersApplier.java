package com.example.oauth2.oauth2client.request;

import com.example.oauth2.oauth2common.OAuth;
import com.example.oauth2.oauth2common.exception.OAuthSystemException;
import com.example.oauth2.oauth2common.message.OAuthMessage;
import com.example.oauth2.oauth2common.parameters.OAuthParametersApplier;
import com.example.oauth2.oauth2common.utils.OAuthUtils;
import java.util.Map;



public class ClientHeaderParametersApplier implements OAuthParametersApplier {

    public OAuthMessage applyOAuthParameters(OAuthMessage message, Map<String, String> params)
        throws OAuthSystemException {

        String header = OAuthUtils.encodeOAuthHeader(params);
        message.addHeader(OAuth.HeaderType.AUTHORIZATION, header);
        return message;

    }

}
