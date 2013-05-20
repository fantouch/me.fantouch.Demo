
package me.fantouch.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import me.fantouch.libs.crash.CrashHandler;
import me.fantouch.libs.log.Logg;


public class TestCrashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 注册crashHandler,实际使用时建议在Application里面执行
        CrashHandler.getInstance().init(getApplicationContext(), SendService.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_crash);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.crashBtn)
            throw new NullPointerException("Yeah~,it crashed");
    }
}
