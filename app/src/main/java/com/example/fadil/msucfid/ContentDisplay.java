package com.example.fadil.msucfid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by fadil
 */

public class ContentDisplay extends AppCompatActivity {

    private WebView mWebview;
    public String contentid;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        contentid = intent.getStringExtra("ID");

        mWebview = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show();
            }
        });

        mWebview.loadUrl("http://e242fe3d.ngrok.io/api/"+ contentid + "/stream_content");
        setContentView(mWebview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Toast.makeText(ContentDisplay.this, "Toing", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ContentDisplay.this, NewPersonalNote.class);
        intent.putExtra("ContentID", contentid);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
