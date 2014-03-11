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


public class OasterBBActivity extends DroidGap {
	private WebView webView;
	String username,password;
	
    // the method to call from the html button click
    // note: this annotation JavascriptInterface, is only required and available if your app has a minsdk of 17 or above
    @JavascriptInterface 
    public void ValidSignin(String str,String psw)
    {
    	String username = str;
    	String password = psw;
    	{
    		if ( (username.equals("User")) && (password.equals("User"))){
    		Intent i = new Intent(OasterBBActivity.this,InsuranceService.class);
            startActivity(i);
    	}else{
    		Toast.makeText(getApplicationContext(), "Username Salah", Toast.LENGTH_LONG).show();
    		
    	}
    	}
    }

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    this.webView = new WebView(this);

        // requires javascript
    this.webView.getSettings().setJavaScriptEnabled(true); 
       
         // set the html view to load
    this.webView.loadUrl("file:///android_asset/www/index.html");
    
        
         // make this activity accessible to javascript
    this.webView.addJavascriptInterface(this, "activity");

    setContentView(this.webView);
}
}