
package me.fantouch.demo;

import android.app.Activity;
import android.os.Bundle;

import me.fantouch.libs.scrolladv.ScrollAdv;

import java.util.ArrayList;
import java.util.List;

public class TestScrollAdvActivity extends Activity {
    ScrollAdv scrollAdv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scrolladv);

        List<String> imgUrls = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            imgUrls.add("http://www.fantouch.me/imgs.demo.fantouch.me/img"
                    + (i + 1) + ".jpg");
        }

        scrollAdv = (ScrollAdv) findViewById(R.id.scroll_adv);
        scrollAdv.setImgs(imgUrls);
    }

    @Override
    protected void onPause() {
        scrollAdv.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        scrollAdv.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        scrollAdv.onDestroy();
        super.onDestroy();
    }

}
