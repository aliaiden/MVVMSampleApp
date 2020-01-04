package com.example.samplefornew.retro;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.samplefornew.MyApplication;
import com.example.samplefornew.model.RefreshToken;
import com.example.samplefornew.model.ResponseRefreshToken;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Callback;

public class TokenAuthenticator implements Authenticator {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RefreshToken refreshTokenData;
    Context context;
    String usrID;
    String token;
    String refreshToken;
    String loginID;
    Response authenticateResponse;

    public TokenAuthenticator() {
        this.context = MyApplication.getContext();
        sharedPreferences = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        usrID = sharedPreferences.getString("usR_ID_ENCRYPTED", "usrID");
        token = sharedPreferences.getString("token", "token");
        refreshToken = sharedPreferences.getString("refreshtoken", "refreshtoken");
        loginID = sharedPreferences.getString("usR_LOGINID", "loginID");
        editor = sharedPreferences.edit();
    }

    @Nullable
    @Override
    public Request authenticate(@Nullable Route route, Response response) throws IOException {

        if (response.code() == 401) {

            refreshTokenData = getRefreshToken();
            APIService service = RetrofitClientInstance.getRetrofitInstance().create(APIService.class);
            Call<ResponseRefreshToken> refreshCall = service.getRefreshToken(refreshTokenData);
            this.authenticateResponse = response;

            refreshCall.enqueue(new Callback<ResponseRefreshToken>() {
                @Override
                public void onResponse(Call<ResponseRefreshToken> call, retrofit2.Response<ResponseRefreshToken> response) {

                    if (response.isSuccessful()) {

                        if (response.body().getData() != null) {

                            editor.putString("token", response.body().getData().getAccessToken());
                            editor.putString("refreshtoken", response.body().getData().getRefreshToken());
                            editor.commit();
                            authenticateResponse.request().newBuilder().header("Authorization", "bearer " + response.body().getData().getAccessToken()).build();


                        } else {
                            Toast.makeText(context, "response is null " + response.message(), Toast.LENGTH_SHORT).show();
                        }

                    } else {

                        Toast.makeText(context, "Response Failure", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onFailure(Call<ResponseRefreshToken> call, Throwable t) {

                    Log.e("Call failure", "failure due to " + t.getMessage());

                }
            });


        }

        return response.request().newBuilder().build();
    }

    private RefreshToken getRefreshToken() {

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUsrIDEncrypted(usrID);
        refreshToken.setAccessToken(token);
        refreshToken.setUsrLoginID(loginID);
        refreshToken.setRefreshToken(this.refreshToken);
        return refreshToken;

    }
}
