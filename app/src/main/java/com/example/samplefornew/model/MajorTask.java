package com.example.samplefornew.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MajorTask implements Serializable {

    @SerializedName("mtasK_ID")
    @Expose
    private int mTaskID;
    @SerializedName("mtasK_NAME")
    @Expose
    private String mTaskName;
    @SerializedName("mtasK_DESC")
    @Expose
    private String mTaskDescription;

    public int getmTaskID() {
        return mTaskID;
    }

    public void setmTaskID(int mTaskID) {
        this.mTaskID = mTaskID;
    }

    public String getmTaskName() {
        return mTaskName;
    }

    public void setmTaskName(String mTaskName) {
        this.mTaskName = mTaskName;
    }

    public String getmTaskDescription() {
        return mTaskDescription;
    }

    public void setmTaskDescription(String mTaskDescription) {
        this.mTaskDescription = mTaskDescription;
    }
}
