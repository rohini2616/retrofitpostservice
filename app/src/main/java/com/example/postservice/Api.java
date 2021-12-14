package com.example.postservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    String Base_Url="https://kuwycredit.in/servlet/rest/ltv/forecast/";

    @POST("ltvMakes")
    Call<MakeResponse> makeList(@Body Model model);
}
