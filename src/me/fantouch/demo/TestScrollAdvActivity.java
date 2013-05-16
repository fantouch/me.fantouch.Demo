
package me.fantouch.demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.tsz.afinal.FinalBitmap;

import me.fantouch.libs.multiviewpager.RefImgDownloader;
import me.fantouch.libs.scrolladv.ScrollAdv;

public class TestScrollAdvActivity extends Activity {
    MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scrolladv);

        mAdapter = new MyPagerAdapter(this);
        ScrollAdv scrollAdv = (ScrollAdv) findViewById(R.id.scroll_adv);
        // scrollAdv.setAdapter(mAdapter);
    }

    @Override
    protected void onPause() {
        mAdapter.fb.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mAdapter.fb.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAdapter.fb.onDestroy();
        super.onDestroy();
    }

    private class MyPagerAdapter extends PagerAdapter {
        private FinalBitmap fb;

        public MyPagerAdapter(Context context) {
            super();
            initFinalBitmap(context);
        }


        private void initFinalBitmap(Context context) {
            fb = FinalBitmap.create(context);
            fb.configDownlader(new RefImgDownloader(context));
            fb.configCompressFormat(Bitmap.CompressFormat.PNG);
            fb.configLoadingImage(android.R.drawable.ic_menu_sort_by_size);
            fb.configLoadfailImage(android.R.drawable.ic_menu_close_clear_cancel);
            fb.configBitmapMaxWidth(getResources().getDimensionPixelSize(R.dimen.pagerWidth));
            fb.configBitmapMaxHeight(getResources()
                    .getDimensionPixelSize(R.dimen.pagerHeight));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View item = View.inflate(TestScrollAdvActivity.this, R.layout.multipager_item,
                    null);

            TextView tv = (TextView) item.findViewById(R.id.txtView);
            tv.setText("第" + (position + 1) + "张");

            ImageView imageView = (ImageView) item.findViewById(R.id.imgView);
            fb.display(imageView,
                    "http://www.fantouch.me/imgs.demo.fantouch.me/img"
                            + (position + 1) +
                            ".jpg");

            container.addView(item);
            return item;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return 22;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }
}
