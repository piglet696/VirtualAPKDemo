package com.virtualapk.host;

import static android.os.Environment.getExternalStorageDirectory;

import java.io.File;

import com.didi.virtualapk.PluginManager;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by piglet696 on 17/7/5.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    public static final String PLUGIN_PKG_NAME = "com.virtualapk.imageplugin";
    public static final String IMG1_URL = "http://pic.wenwen.soso.com/p/20130809/20130809170922-693425734.jpg";
    public static final String IMG2_URL = "http://img2.imgtn.bdimg.com/it/u=2881489320,987765159&fm=214&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView homeIconIv1 = (ImageView) findViewById(R.id.iv_home_icon1);
        ImageView homeIconIv2 = (ImageView) findViewById(R.id.iv_home_icon2);
        Button imageBrowserBtn = (Button) findViewById(R.id.btn_image_browser);

        Picasso.with(this).load(IMG1_URL).into(homeIconIv1);
        Picasso.with(this).load(IMG2_URL).into(homeIconIv2);

        loadPlugin(this);
        imageBrowserBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (PluginManager.getInstance(this).getLoadedPlugin(PLUGIN_PKG_NAME) == null) {
            Toast.makeText(getApplicationContext(),
                    "插件未加载,请尝试重启APP", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        intent.setClassName("com.virtualapk.imageplugin", "com.virtualapk.imageplugin.ImageBrowserActivity");
        startActivity(intent);
    }

    private void loadPlugin(Context base) {
        PluginManager pluginManager = PluginManager.getInstance(base);
        File apk = new File(getExternalStorageDirectory(), "plugin.apk");
        if (apk.exists()) {
            try {
                pluginManager.loadPlugin(apk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "SDcard根目录未检测到plugin.apk插件", Toast.LENGTH_SHORT).show();
        }
    }
}
