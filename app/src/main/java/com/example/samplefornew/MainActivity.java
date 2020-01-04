package com.example.samplefornew;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.samplefornew.databinding.ActivityTaskAssignBinding;
import com.example.samplefornew.model.MainTaskModel;
import com.example.samplefornew.viewmodel.FixedTaskViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ActivityTaskAssignBinding taskAssignBinding;

    FixedTaskViewModel fixedTaskViewModel;

    Calendar myCalendar = Calendar.getInstance();
    private int SELECT_MSR_INTENT = 1;
    private MainTaskModel mainTaskModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        taskAssignBinding = DataBindingUtil.setContentView(this, R.layout.activity_task_assign);

        fixedTaskViewModel = ViewModelProviders.of(this).get(FixedTaskViewModel.class);


        taskAssignBinding.setTaskAssignmentViewModel(fixedTaskViewModel);
        taskAssignBinding.setActivity(this);


        fixedTaskViewModel.mainTaskModelMutableLiveData.observe(this, mainTaskModel -> {
            this.mainTaskModel = mainTaskModel;
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        taskAssignBinding.tvSelectMsr.setClickable(true);
        taskAssignBinding.ivAddProduct.setClickable(true);

    }

    private void updateLabelEndDate() {
        String myFormat = "dd-MMM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        //dateTextView.setText(sdf.format(myCalendar.getTime()));
        fixedTaskViewModel.setEndDate(sdf.format(myCalendar.getTime()));

        taskAssignBinding.llEndDate.setClickable(true);

    }

    private void updateLabelStartDate() {

        String myFormat = "dd-MMM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        fixedTaskViewModel.setStartDate(sdf.format(myCalendar.getTime()));

        taskAssignBinding.llStartDate.setClickable(true);

    }

    public void onStartTimeClicked() {

        taskAssignBinding.llStartTime.setClickable(false);
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(this, (timePicker, selectedHour, selectedMinute) -> {
//                            fragmentFixedTaskBinding.textviewStartTime.setText(selectedHour + ":" + selectedMinute);
            fixedTaskViewModel.setStartTime(selectedHour + ":" + selectedMinute);
            taskAssignBinding.llStartTime.setClickable(true);
        }, hour, minute, false);//Yes 24 hour time

        mTimePicker.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                taskAssignBinding.llStartTime.setClickable(true);

            }
        });

        mTimePicker.setTitle("Select Time");
        mTimePicker.setCanceledOnTouchOutside(false);
        mTimePicker.show();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        taskAssignBinding.llStartTime.setClickable(true);
        taskAssignBinding.llEndTime.setClickable(true);
        taskAssignBinding.llEndDate.setClickable(true);
        taskAssignBinding.llStartDate.setClickable(true);

    }

    public void onEndTimeClicked() {

        taskAssignBinding.llEndTime.setClickable(false);
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(this, (timePicker, selectedHour, selectedMinute) -> {
            fixedTaskViewModel.setEndTime(selectedHour + ":" + selectedMinute);
            taskAssignBinding.llEndTime.setClickable(true);
        }, hour, minute, false);//Yes 24 hour time

        mTimePicker.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                taskAssignBinding.llEndTime.setClickable(true);

            }
        });

        mTimePicker.setTitle("Select Time");
        mTimePicker.setCanceledOnTouchOutside(false);
        mTimePicker.show();
    }

    public void onStartDateClicked() {

        taskAssignBinding.llStartDate.setClickable(false);
        DatePickerDialog.OnDateSetListener startDate = (view, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabelStartDate();

        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, startDate, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                taskAssignBinding.llStartDate.setClickable(true);

            }
        });

        datePickerDialog.setCanceledOnTouchOutside(false);

        datePickerDialog.show();

    }


    public void onEndDateClicked() {

        taskAssignBinding.llEndDate.setClickable(false);

        DatePickerDialog.OnDateSetListener endDate = (view, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabelEndDate();

        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, endDate, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                taskAssignBinding.llEndDate.setClickable(true);

            }
        });

        datePickerDialog.setCanceledOnTouchOutside(false);

        datePickerDialog.show();

    }

    public void onAddProductClick() {

        taskAssignBinding.ivAddProduct.setClickable(false);

    }

    public void onNextClicked() {
        Log.e("maintaskmodel", mainTaskModel.toString());

        Intent i = new Intent(this, NextActivity.class);
        i.putExtra("isOpen", mainTaskModel.isOpen());
        i.putExtra("sDate", mainTaskModel.getStartDate());
        i.putExtra("sTime", mainTaskModel.getStartTime());
        i.putExtra("eDate", mainTaskModel.getEndDate());
        i.putExtra("eTime", mainTaskModel.getEndTime());
        i.putExtra("priority", mainTaskModel.getPriority());
        i.putExtra("notes", mainTaskModel.getNotes());
        startActivity(i);
    }

    public void onSelectMSRClicked() {
//        Intent i = new Intent(this, SelectMsrActivity.class);
//        startActivityForResult(i, SELECT_MSR_INTENT);
//
//        taskAssignBinding.tvSelectMsr.setClickable(false);


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == SELECT_MSR_INTENT) {
//            if (resultCode == RESULT_OK) {
//
//                Msr msr = (Msr) data.getSerializableExtra("msr");
//                fixedTaskViewModel.setMsrName(msr.getMsrFullName());
//
//            }
//
//
//        }
//    }
}
