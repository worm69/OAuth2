package com.example.oauth2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.net.toUri
import com.example.oauth2.oauth2client.OAuthClient
import com.example.oauth2.oauth2client.URLConnectionClient
import com.example.oauth2.oauth2client.request.OAuthClientRequest
import kotlinx.android.synthetic.main.activity_main.webView1
import com.example.oauth2.oauth2common.message.types.GrantType.AUTHORIZATION_CODE

class MainActivity : AppCompatActivity() {
    private var browserIntent : Intent? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var request: OAuthClientRequest? = null
        request = OAuthClientRequest
            .authorizationLocation("https://anilist.co/api/v2/oauth/authorize")
            .setClientId("1542").setRedirectURI("https://anilist.co/api/v2/oauth/pin")
            .buildQueryMessage()

        val webview = findViewById<WebView>(R.id.webView1)
        webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                Log.d("WebView", "your current url when webpage loading..$url")
            }

            override   fun onPageFinished(view: WebView, url: String) {
                Log.d("WebView", "your current url when webpage loading.. finish$url")

                super.onPageFinished(view, url)

                getCode()

            }

            override fun onLoadResource(view: WebView, url: String) {
                // TODO Auto-generated method stub
                super.onLoadResource(view, url)
            }

            override  fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                println("when you click on any interlink on webview that time you got url :-$url")
                return super.shouldOverrideUrlLoading(view, url)
            }
        }
        webview.settings.javaScriptEnabled = true
        webview.settings.javaScriptCanOpenWindowsAutomatically = true
        webview.settings.domStorageEnabled = true
        webview.loadUrl( Uri.parse(request!!.locationUri + "&response_type=code").toString())
    }

    private fun getCode() {
        val uri = webView1.url.toUri()
        if (uri.toString()
                .startsWith("https://anilist.co/api/v2/oauth/pin?code=")
        ) {
            val code = uri.getQueryParameter("code")
            var request: OAuthClientRequest? = null



            request = OAuthClientRequest.tokenLocation("https://anilist.co/api/v2/oauth/token")
                .setGrantType(AUTHORIZATION_CODE)
                .setClientId("1542")
                .setClientSecret("jA95juoTN2BshTKueYdCqNz9Aaw9SZiq94Rr7oYh")
                .setRedirectURI("https://anilist.co/api/v2/oauth/pin")
                .setCode(code)
                .buildBodyMessage()





            val thread = Thread(Runnable {
                try {
                    val oAuthClient = OAuthClient(URLConnectionClient())
                    val headers = mutableMapOf("Content-Type" to "application/json", "Accept" to "application/json")
                    request.headers = headers
                    val response = oAuthClient.accessToken(request)
                    val token = response.accessToken
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            })

            thread.start()

//            val oAuthClient = OAuthClient(URLConnectionClient())
//
//            val response = oAuthClient.accessToken(request)
//            val token = response.accessToken
        }
    }
}
