
package me.fantouch.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import me.fantouch.libs.log.Logg;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logg.d("Hello~~");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Logg.sendReportFiles(getApplicationContext(), SendService.class);
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.updateHelper) {
            startActivity(new Intent(this, TestUpdateHelperActivity.class));
        } else if (id == R.id.log) {
            startActivity(new Intent(this, TestLogActivity.class));
        } else if (id == R.id.crash) {
            startActivity(new Intent(this, TestCrashActivity.class));
        } else if (id == R.id.indicativeRadioGp) {
            startActivity(new Intent(this, TestIndicativeRadioGpActivity.class));
        } else if (id == R.id.indicativeRadioGpByCode) {
            startActivity(new Intent(this, TestIndicativeRadioGpByCodeActivity.class));
        } else if (id == R.id.IOSTitleBar) {
            startActivity(new Intent(this, TestIOSTitleBarActivity.class));
        } else if (id == R.id.MultiViewPager) {
            startActivity(new Intent(this, TestMultiPagerViewActivity.class));
        }

    }
}
