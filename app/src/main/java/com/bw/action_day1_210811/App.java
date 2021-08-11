package com.bw.action_day1_210811;

import android.app.Application;
import android.content.Context;

public
class App extends Application {
    //设置全局可调用的上下文
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

}
