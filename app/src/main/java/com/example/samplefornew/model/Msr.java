package com.example.samplefornew.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Msr implements Serializable {

    @SerializedName("usR_ID")
    @Expose
    private int msrID;
    @SerializedName("usR_ID_ENCRYPTED")
    @Expose
    private String usrIdEncrypted;
    @SerializedName("usR_FULLNAME")
    @Expose
    private String msrFullName;


    public int getMsrID() {
        return msrID;
    }

    public void setMsrID(int msrID) {
        this.msrID = msrID;
    }

    public String getUsrIdEncrypted() {
        return usrIdEncrypted;
    }

    public void setUsrIdEncrypted(String usrIdEncrypted) {
        this.usrIdEncrypted = usrIdEncrypted;
    }

    public String getMsrFullName() {
        return msrFullName;
    }

    public void setMsrFullName(String msrFullName) {
        this.msrFullName = msrFullName;
    }
}
