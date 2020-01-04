package com.example.samplefornew.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class LoginModel extends BaseObservable {
    private boolean enabled;
    private String userName;
    private String password;

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(com.example.samplefornew.BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(com.example.samplefornew.BR.password);
    }

    @Bindable
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        notifyPropertyChanged(com.example.samplefornew.BR.enabled);
    }
}
