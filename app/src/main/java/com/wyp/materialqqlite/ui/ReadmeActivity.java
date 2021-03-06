package com.wyp.materialqqlite.ui;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;


import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.wyp.materialqqlite.R;

public class ReadmeActivity extends ActionBarActivity {
    private SharedPreferences sp;
    private int color_theme;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readme);
        WebView webView= (WebView) findViewById(R.id.webview_readme);
        webView.loadUrl(" file:///android_asset/readme.html ");

        sp=getSharedPreferences("theme",MODE_PRIVATE);
        color_theme=sp.getInt("color", -12627531);
        toolbar= (Toolbar) findViewById(R.id.toolbar_readme);
        toolbar.setBackgroundColor(color_theme);
        toolbar.setTitle(R.string.readme);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintColor(color_theme);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
