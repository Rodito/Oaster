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


public class MyPremiumBill extends DroidGap {
	private WebView webView;
	
	@JavascriptInterface 
    public void Map()
    {
    		Intent i = new Intent(this,Map.class);
            startActivity(i);
    }
	
	@JavascriptInterface 
	public void Bill()
    {
    		Intent i = new Intent(this,MyPremiumBill.class);
            startActivity(i);
    }
	
	@JavascriptInterface 
	public void Claim()
    {
    		Intent i = new Intent(this,MyClaimTransaction.class);
            startActivity(i);
    }
	
	@JavascriptInterface 
	public void Benefit()
    {
    		Intent i = new Intent(this,BenefitRegistration.class);
            startActivity(i);
    }

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    this.webView = new WebView(this);

        // requires javascript
    this.webView.getSettings().setJavaScriptEnabled(true); 
       
         // set the html view to load
    this.webView.loadUrl("file:///android_asset/www/MyPremiumBill.html");
    
        
         // make this activity accessible to javascript
    this.webView.addJavascriptInterface(this, "activity");

    setContentView(this.webView);
}
}