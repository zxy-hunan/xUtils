package com.zxy_hunan.testutilapp;

import com.zyx_hunan.baseutil.net.ApiPath;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TestService extends ApiPath {
        @GET("/banner/json")
        Observable<BannerModel> bannerList();
}
