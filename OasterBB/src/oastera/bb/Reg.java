package oastera.bb;

import org.apache.cordova.DroidGap;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;


public class Reg extends DroidGap {
	private WebView webView;
	
    
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    this.webView = new WebView(this);

        // requires javascript
    this.webView.getSettings().setJavaScriptEnabled(true); 
       
         // set the html view to load
    this.webView.loadUrl("file:///android_asset/www/reg.html");
    
        
         // make this activity accessible to javascript
    this.webView.addJavascriptInterface(this, "activity");

    setContentView(this.webView);
}
}