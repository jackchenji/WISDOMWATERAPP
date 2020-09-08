package com.cdwm.app.ui.web;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.cdwm.app.R;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

public static String title="";
public static String url="";

    AgentWeb mAgentWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(title);
        }


        //AgentWebView webView= (AgentWebView) findViewById(R.id.webView);
        LinearLayout webViewLinearLayout = findViewById(R.id.webviewLineLayout);
        this.mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(webViewLinearLayout,new LinearLayout.LayoutParams(-1,-1) )
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                //.setSecutityType(AgentWeb.SecurityType.DEFAULT_CHECK)
                .createAgentWeb()
                .ready()
                .go(url);

    }



    private WebViewClient mWebViewClient=new WebViewClient(){
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
        }
    };
    private WebChromeClient mWebChromeClient=new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (!mAgentWeb.back()) {
                   this.finish();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
