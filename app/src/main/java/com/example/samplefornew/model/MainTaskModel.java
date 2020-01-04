package com.example.samplefornew.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class MainTaskModel extends BaseObservable {
    private boolean isOpen;
    private String msrID;
    private String msrName = "Select MSR";
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private int priority;
    private String notes;
    private String lmId;

    @Bindable
    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
        notifyPropertyChanged(com.example.samplefornew.BR.open);
    }

    public String getMsrID() {
        return msrID;
    }

    public void setMsrID(String msrID) {
        this.msrID = msrID;
    }

    @Bindable
    public String getMsrName() {
        return msrName;
    }

    public void setMsrName(String msrName) {
        this.msrName = msrName;
        notifyPropertyChanged(com.example.samplefornew.BR.msrName);
    }

    @Bindable
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
        notifyPropertyChanged(com.example.samplefornew.BR.startDate);
    }

    @Bindable
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
        notifyPropertyChanged(com.example.samplefornew.BR.startTime);
    }

    @Bindable
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
        notifyPropertyChanged(com.example.samplefornew.BR.endDate);
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
        notifyPropertyChanged(com.example.samplefornew.BR.endTime);
    }

    @Bindable
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
        notifyPropertyChanged(com.example.samplefornew.BR.priority);
    }

    @Bindable
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
        notifyPropertyChanged(com.example.samplefornew.BR.notes);
    }

    public String getLmId() {
        return lmId;
    }

    public void setLmId(String lmId) {
        this.lmId = lmId;
    }
}
