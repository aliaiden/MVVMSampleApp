package com.example.samplefornew.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.samplefornew.model.LoginModel;
import com.example.samplefornew.model.LoginResponseModel;
import com.example.samplefornew.repository.LoginRepository;

public class LoginActivityViewModel extends AndroidViewModel {
    private final LoginModel loginModel;
    LoginRepository loginRepository;
    public MutableLiveData<LoginModel> loginModelMutableLiveData;
    public MutableLiveData<LoginResponseModel> loginResponse;
    public MutableLiveData<String> errorResponse;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository();

        errorResponse = loginRepository.error();
        loginResponse = loginRepository.loginResponse();

        loginModelMutableLiveData = new MutableLiveData<>();
        loginModel = new LoginModel();
        loginModel.setEnabled(true);
        loginModelMutableLiveData.setValue(loginModel);
    }

    public void onLoginClicked() {
        loginModel.setEnabled(false);
        loginRepository.login(loginModel.getUserName(), loginModel.getPassword());
    }

}
