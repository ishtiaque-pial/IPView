package com.pial.ramizvai.retrofit;

import com.pial.ramizvai.pojoClass.LoginPojo;
import com.pial.ramizvai.pojoClass.PhotoPojo;
import com.pial.ramizvai.pojoClass.UrlPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by pial on 12/9/17.
 */

public interface Api {
    @Headers("Content-Type: application/json")
    @POST("endPont")
    Call<LoginPojo> loginUser(@Body LoginPojo loginPojo);

    @GET("/Todos")
    Call<ArrayList<UrlPojo>> urlPojo();

    @GET("/photo")
    Call<ArrayList<PhotoPojo>> photoUrlPojo();
}
