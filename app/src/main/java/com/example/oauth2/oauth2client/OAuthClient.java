package com.example.oauth2.oauth2client;
import com.example.oauth2.oauth2client.request.OAuthClientRequest;
import com.example.oauth2.oauth2client.response.OAuthAccessTokenResponse;
import com.example.oauth2.oauth2client.response.OAuthJSONAccessTokenResponse;
import com.example.oauth2.oauth2common.OAuth;
import com.example.oauth2.oauth2common.exception.OAuthProblemException;
import com.example.oauth2.oauth2common.exception.OAuthSystemException;
import java.util.HashMap;
import java.util.Map;


public class OAuthClient {

    protected HttpClient httpClient;

    public OAuthClient(HttpClient oauthClient) {
        this.httpClient = oauthClient;
    }

    public <T extends OAuthAccessTokenResponse> T accessToken(
        OAuthClientRequest request,
        Class<T> responseClass)
        throws OAuthSystemException, OAuthProblemException {
        Map<String, String> headers = new HashMap<String, String>();
        String method = OAuth.HttpMethod.POST;
        if(request.getHeaders()!=null){
            headers = request.getHeaders();
            headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.URL_ENCODED);
        }else {
            headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.URL_ENCODED);
        }


        return httpClient.execute(request, headers, method, responseClass);
    }

    public OAuthJSONAccessTokenResponse accessToken(
        OAuthClientRequest request)
        throws OAuthSystemException, OAuthProblemException {
        return accessToken(request, OAuthJSONAccessTokenResponse.class);
    }
}
