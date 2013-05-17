
package me.fantouch.demo;

import android.app.Activity;
import android.os.Bundle;

import me.fantouch.libs.log.Logg;
import me.fantouch.libs.scrolladv.ScrollAdv;
import me.fantouch.libs.scrolladv.ScrollAdv.OnImgClickListener;

import java.util.ArrayList;
import java.util.List;

public class TestScrollAdvActivity extends Activity {
    ScrollAdv scrollAdv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scrolladv);

        // 图片url列表
        List<String> imgUrls = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            imgUrls.add("http://www.fantouch.me/imgs.demo.fantouch.me/img"
                    + (i + 1) + ".jpg");
        }

        // 图片点击监听器
        OnImgClickListener imgClickListener = new OnImgClickListener() {
            @Override
            public void onImgClick(int postion) {
                Logg.d(postion + "");
            }
        };

        scrollAdv = (ScrollAdv) findViewById(R.id.scroll_adv);
        scrollAdv.setImgs(imgUrls, imgClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        scrollAdv.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scrollAdv.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        scrollAdv.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scrollAdv.onResume();
    }

    @Override
    protected void onDestroy() {
        scrollAdv.onDestroy();
        super.onDestroy();
    }

}
