package com.example.samplefornew.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RefreshToken {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;
    @SerializedName("fcmDeviceToken")
    @Expose
    private String fcmDeviceToken;
    @SerializedName("usR_ID")
    @Expose
    private int usrID;
    @SerializedName("usR_ID_ENCRYPTED")
    @Expose
    private String usrIDEncrypted;
    @SerializedName("usR_LOGINID")
    @Expose
    private String usrLoginID;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("isActive")
    @Expose
    private boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getFcmDeviceToken() {
        return fcmDeviceToken;
    }

    public void setFcmDeviceToken(String fcmDeviceToken) {
        this.fcmDeviceToken = fcmDeviceToken;
    }

    public int getUsrID() {
        return usrID;
    }

    public void setUsrID(int usrID) {
        this.usrID = usrID;
    }

    public String getUsrIDEncrypted() {
        return usrIDEncrypted;
    }

    public void setUsrIDEncrypted(String usrIDEncrypted) {
        this.usrIDEncrypted = usrIDEncrypted;
    }

    public String getUsrLoginID() {
        return usrLoginID;
    }

    public void setUsrLoginID(String usrLoginID) {
        this.usrLoginID = usrLoginID;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
