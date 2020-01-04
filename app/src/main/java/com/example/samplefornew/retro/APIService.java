package com.example.samplefornew.retro;

import com.example.samplefornew.model.LoginResponseModel;
import com.example.samplefornew.model.RefreshToken;
import com.example.samplefornew.model.ResponseRefreshToken;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface APIService {

    @Headers({"Content-Type:application/json"})
    @POST("User/Login")
    Call<LoginResponseModel> login(@Body Map<String, String> versionId);

    @POST("User/RefreshToken")
    Call<ResponseRefreshToken> getRefreshToken(@Body RefreshToken refreshToken);

}