package com.example.samplefornew.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.samplefornew.model.MainTaskModel;
import com.example.samplefornew.model.TaskMsr;
import com.example.samplefornew.repository.FixedTaskRepository;


public class FixedTaskViewModel extends AndroidViewModel {

    Context context;
    FixedTaskRepository fixedTaskRepository;
    public MutableLiveData<MainTaskModel> mainTaskModelMutableLiveData;
    private MainTaskModel mainTask;
    // public MutableLiveData<TaskAssign> taskAssign = new MutableLiveData<>();

    public FixedTaskViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        fixedTaskRepository = FixedTaskRepository.getInstance(context);
        mainTask = new MainTaskModel();

        mainTaskModelMutableLiveData = new MutableLiveData<>();
        mainTaskModelMutableLiveData.setValue(mainTask);
    }

    public LiveData<TaskMsr> getTaskMsrViewModel() {
        return fixedTaskRepository.getTaskMsrRepo();
    }

    public void setStartTime(String time) {

        mainTask.setStartTime(time);
        mainTaskModelMutableLiveData.setValue(mainTask);


    }

    public void setEndTime(String s) {
        mainTask.setEndTime(s);
    }

    public void setStartDate(String format) {
        mainTask.setStartDate(format);
    }

    public void setEndDate(String format) {
        mainTask.setEndDate(format);
    }
}
