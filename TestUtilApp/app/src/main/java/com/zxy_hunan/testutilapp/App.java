package com.zxy_hunan.testutilapp;

import android.app.Application;

import com.zyx_hunan.baseutil.net.util.NetUtil;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetUtil.options().setApiPath(TestService.class)
                .setDefault_time(10)
                .setEnableLog(true)
                .setUrl("https://www.wanandroid.com");
    }
}
