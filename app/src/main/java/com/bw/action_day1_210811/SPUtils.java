package com.bw.action_day1_210811;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public
class SPUtils {

    private SharedPreferences sp;

    private static SPUtils spUtils = null;

    /**
     * 防止new对象
     */
    private SPUtils() {
        sp = App.context.getSharedPreferences("sp", Context.MODE_PRIVATE);
    }

    /**
     * 双重懒汉式单例
     * @return
     */
    public static SPUtils getInstance() {
        if (spUtils==null){
            synchronized (SPUtils.class){
                if (spUtils==null){
                    spUtils = new SPUtils();
                }
            }
        }
        return spUtils;
    }

    /**
     * 获取SP对象
     * @return
     */
    public SharedPreferences getSp(){
            return sp;
    }

    /**
     * 自动添加
     * @param key
     * @param o
     */
    public void setSp(String key,Object o){
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor edit = sp.edit();
        if (o instanceof String){
            edit.putString(key, (String) o);
        }else if (o instanceof Integer){
            edit.putInt(key,(Integer) o);
        }else if (o instanceof Boolean){
            edit.putBoolean(key, (Boolean) o);
        }
        edit.apply();
    }


}
