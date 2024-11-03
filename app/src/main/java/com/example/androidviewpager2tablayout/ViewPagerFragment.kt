package com.example.androidviewpager2tablayout

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val website = view.findViewById<WebView>(R.id.webView)
        val data = arguments?.getSerializable("web") as MyWebsite
//        website.webViewClient = WebViewClient()
        website.settings.apply {
            domStorageEnabled = true
            cacheMode = android.webkit.WebSettings.LOAD_DEFAULT
            javaScriptEnabled = true
        }
        website.loadUrl(data.website)
//        website.settings.javaScriptEnabled = true
//        website.settings.setSupportZoom(true)
//        website.webViewClient = object :WebViewClient(){
//            @Deprecated("Deprecated in Java")
//            override fun shouldOverrideUrlLoading(
//                view: WebView?,
//                request: String
//            ): Boolean {
//                view?.loadUrl(request)
//                return true
//            }
//        }
//        website.loadUrl(data.website)
//        WebView.setWebContentsDebuggingEnabled(true)
//        val webIntent = Intent(Intent.ACTION_VIEW)
//        webIntent.data = Uri.parse(data.website)
//        startActivity(webIntent)
    }
}