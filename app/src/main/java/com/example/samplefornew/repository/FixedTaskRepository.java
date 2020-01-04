package com.example.samplefornew.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.samplefornew.model.TaskMsr;

public class FixedTaskRepository {
    final MutableLiveData<TaskMsr> taskMsrData = new MutableLiveData<>();

    private static FixedTaskRepository fixedTaskRepository;
    String token;
    String userID;

    public static FixedTaskRepository getInstance(Context context) {

        if (fixedTaskRepository == null) {

            fixedTaskRepository = new FixedTaskRepository();

        }

        return fixedTaskRepository;

    }

    public LiveData<TaskMsr> getTaskMsrRepo() {

//        if (Util.checkConnection(context)) {
//
//            APIService service = RetrofitClientInstance.getRetrofitInstance().create(APIService.class);
//            Call<TaskMsr> call = service.getTaskMsrList("bearer " + token, userID);
//            call.enqueue(new Callback<TaskMsr>() {
//                @Override
//                public void onResponse(Call<TaskMsr> call, Response<TaskMsr> response) {
//
//                    if (response.isSuccessful()) {
//
//                        TaskMsr taskMsr = response.body();
//                        if (taskMsr != null) {
//                            taskMsrData.setValue(response.body());
//                        } else {
//                            Toast.makeText(context, "Response is null", Toast.LENGTH_SHORT).show();
//                            taskMsrData.setValue(null);
//                        }
//                    } else {
//
//                        taskMsrData.setValue(response.body());
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<TaskMsr> call, Throwable t) {
//                    Log.e("failure", "onFailure: " + t.getMessage());
//                }
//            });
//
//
//        } else {
//            Toast.makeText(context, "Connection failure", Toast.LENGTH_SHORT).show();
//        }

        return taskMsrData;
    }
}
