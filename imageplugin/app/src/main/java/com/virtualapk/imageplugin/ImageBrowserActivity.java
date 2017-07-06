package com.virtualapk.imageplugin;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhuhongyu on 17/7/5.
 */

public class ImageBrowserActivity extends Activity {

    public static final String IMG1_URL = "http://imgtu.5011.net/uploads/content/20170207/3424401486455282.jpg";
    public static final String IMG2_URL = "http://wenwen.soso.com/p/20091231/20091231130529-1963909295.jpg";
    public static final String IMG3_URL = "http://img.17k.com/images/bookcover/2012/608/3/121692.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_browser);

        ImageView homeIcon1 = (ImageView) findViewById(R.id.iv_home_icon1);
        ImageView homeIcon2 = (ImageView) findViewById(R.id.iv_home_icon2);
        ImageView homeIcon3 = (ImageView) findViewById(R.id.iv_home_icon3);

        Picasso.with(this).load(IMG1_URL).into(homeIcon1);
        Picasso.with(this).load(IMG2_URL).into(homeIcon2);
        Picasso.with(this).load(IMG3_URL).into(homeIcon3);
    }
}
