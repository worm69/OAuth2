package com.example.oauth2.oauth2client;
import com.example.oauth2.oauth2client.request.OAuthClientRequest;
import com.example.oauth2.oauth2client.response.OAuthClientResponse;
import com.example.oauth2.oauth2common.exception.OAuthProblemException;
import com.example.oauth2.oauth2common.exception.OAuthSystemException;
import java.util.Map;


public interface HttpClient {

    public <T extends OAuthClientResponse> T execute(
        OAuthClientRequest request,
        Map<String, String> headers,
        String requestMethod,
        Class<T> responseClass)
        throws OAuthSystemException, OAuthProblemException;
}
