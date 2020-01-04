package com.example.samplefornew.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.samplefornew.model.LoginResponseModel;
import com.example.samplefornew.retro.APIService;
import com.example.samplefornew.retro.RetrofitClientInstance;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    final MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    final MutableLiveData<LoginResponseModel> data = new MutableLiveData<>();

    public MutableLiveData<LoginResponseModel> login(String userName, String password) {

        //hash map
        Map<String, String> params = new HashMap<>();
        params.put("usR_LOGINID", userName);
        params.put("usR_PASSWORD", password);
        //service intialization
        APIService service = RetrofitClientInstance.getRetrofitInstance().create(APIService.class);
        //service call (login)
        Call<LoginResponseModel> call = service.login(params);

        //calling the api
        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {

                if (response.isSuccessful()) {
                    //response from api
//                    token = response.headers().get("token");
//                    refreshToken = response.headers().get("refreshtoken");
//                    Log.d("tokens", token + "");
                    Log.i("Login Response >>>", response.body() + "");

                    assert response.body() != null;
                    if (response.body().getStatusCode() == 200) {

                        if (response.body().getIsSuccess()) {
                            //     dialog.dismiss();
                            //data isnsertion into shared preference
//                            editor.putString("token", token);
//                            editor.putString("refreshtoken", refreshToken);
//                            editor.putInt("usR_ID", response.body().getData().getUsRID());
//
//                            editor.putInt("msr_id", response.body().getData().getId());
//                            editor.putInt("rolE_ID", response.body().getData().getRoleID());
//                            editor.putString("role_NAME", response.body().getData().getRoleName());
//                            editor.putString("usR_LOGINID", response.body().getData().getUsRLOGINID());
//                            editor.putString("msR_ID_ENCRYPTED", response.body().getData().getIdEncrypted());
//
//
//                            editor.putString("usR_ID_ENCRYPTED", response.body().getData().getUsrIDEncrypted());
//                            editor.putString("msr_email", response.body().getData().getEmail());
//                            editor.putString("msr_address", response.body().getData().getAddress());
//                            editor.putString("msr_cell_no", response.body().getData().getCellno());
//                            editor.putString("msr_first_name", response.body().getData().getFirstname());
//                            editor.putString("msr_last_name", response.body().getData().getLastname());
//                            editor.putString("msr_middle_name", response.body().getData().getMiddlename());
//                            editor.putString("msr_pic", response.body().getData().getPic());
//                            editor.putString("msr_comp_name", response.body().getData().getComPNAME());
//                            editor.putString("msr_dob", response.body().getData().getDob());
//                            editor.putString("msr_cnic", response.body().getData().getCnic());
//                            editor.putString("msr_gender", response.body().getData().getGender());
//                            editor.putString("lM_ID_ENCRYPTED",response.body().getData().getLmIDEncrypted());
//                            editor.commit();
                            data.setValue(response.body());

                        } else {

                            Log.e("Login Error", "Login Problem");
                            errorLiveData.setValue(response.body().getMessage());

                        }
                    } else {
                        Log.e("Login Error", "Login Problem");
                        errorLiveData.setValue(response.body().getMessage());
                        //   dialog.dismiss();
//                    et_userName.requestFocus();
//                    et_userName.setError("Username or password is incorrect");
//                    et_password.getText().clear();
                    }
                } else {

                    errorLiveData.setValue(response.message());

                }
            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Log.e("Failure due to", t.getMessage());
                errorLiveData.setValue(t.getMessage());
            }
        });

        return data;

    }

    public MutableLiveData<String> error() {
        return errorLiveData;
    }

    public MutableLiveData<LoginResponseModel> loginResponse() {
        return data;
    }
}
