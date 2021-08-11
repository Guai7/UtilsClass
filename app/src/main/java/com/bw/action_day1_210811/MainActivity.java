package com.bw.action_day1_210811;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

public class MainActivity extends AppCompatActivity {

    public static final String TAG  = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SPUtils.getInstance().setSp("星星","星星还是那么靓");

        String xing = SPUtils.getInstance().getSp().getString("星星", "123");
        Toast.makeText(this, xing, Toast.LENGTH_SHORT).show();
    }

    /**
     * 将状态栏内的图标颜色 进行调节
     * @param activity
     * @param dark
     */
    public static void setAndroidNativeLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        //如果是深色 则将图标变为亮色，否则变为暗色
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
        //依旧将状态栏设为透明
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    public static void setVideoWindow(Activity activity){
        View decorView = activity.getWindow().getDecorView();
        int flag = View.SYSTEM_UI_FLAG_FULLSCREEN       //隐藏状态栏 下拉重新出现
                |View.SYSTEM_UI_FLAG_LAYOUT_STABLE      //出现时 不占用全局位置  会自动隐藏ActionBar
                |SYSTEM_UI_FLAG_HIDE_NAVIGATION         //隐藏Home栏
                |SYSTEM_UI_FLAG_IMMERSIVE_STICKY;       //半透明状态栏 并且在一段时间后消失。


        decorView.setSystemUiVisibility(flag);
    }
}