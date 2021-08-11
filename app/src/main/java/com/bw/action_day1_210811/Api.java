package com.bw.action_day1_210811;

import io.reactivex.Observable;
import retrofit2.http.GET;

public
interface Api {

    public static final String foodUrl = "http://www.qubaobei.com/";

    @GET("/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<FoodBean> getFood();
}
