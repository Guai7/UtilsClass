package com.bw.action_day1_210811;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public
class ImageViewLoader {

    /**
     * 加载图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void load(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }

    /**
     * 加载圆形
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadCir(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).apply(new RequestOptions().circleCrop()).into(imageView);
    }

    /**
     * 加载圆角图
     * @param context
     * @param url
     * @param imageView
     * @param radius
     */
    public static void loadRadius(Context context, String url, ImageView imageView,int radius){
        Glide.with(context).load(url).transform(new RoundedCorners(radius)).into(imageView);
    }

    /**
     * 加载自定义大小图片
     * @param context
     * @param url
     * @param imageView
     * @param width
     * @param height
     */
    public static void loadWH(Context context, String url, ImageView imageView,int width,int height){
        Glide.with(context).load(url).override(width,height).into(imageView);
    }

}
