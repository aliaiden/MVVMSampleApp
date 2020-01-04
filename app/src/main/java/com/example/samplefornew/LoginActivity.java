package com.example.samplefornew;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.samplefornew.databinding.ActivityLoginBinding;
import com.example.samplefornew.viewmodel.LoginActivityViewModel;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding loginActivityBinding;
    private LoginActivityViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginViewModel = ViewModelProviders.of(this).get(LoginActivityViewModel.class);

        loginActivityBinding.setLoginActivityViewModel(loginViewModel);
        loginActivityBinding.setActivity(this);

        //observe success response
        loginViewModel.loginResponse.observe(this, loginResponseModel -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        //observe error response
        loginViewModel.errorResponse.observe(this, errorMessage -> {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
            loginViewModel.loginModelMutableLiveData.getValue().setEnabled(true);
        });
    }
}
