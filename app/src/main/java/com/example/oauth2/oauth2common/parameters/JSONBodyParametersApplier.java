
package com.example.oauth2.oauth2common.parameters;

import com.example.oauth2.oauth2common.exception.OAuthSystemException;
import com.example.oauth2.oauth2common.message.OAuthMessage;
import com.example.oauth2.oauth2common.utils.JSONUtils;
import java.util.Map;
import org.codehaus.jettison.json.JSONException;




public class JSONBodyParametersApplier implements OAuthParametersApplier {
    public OAuthMessage applyOAuthParameters(OAuthMessage message, Map<String, String> params)
        throws OAuthSystemException {
        String json = null;
        try {
            json = JSONUtils.buildJSON(params);
            message.setBody(json);
            return message;
        } catch (JSONException e) {
            throw new OAuthSystemException(e);
        }
    }
}
