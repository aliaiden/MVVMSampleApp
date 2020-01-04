package com.example.samplefornew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.samplefornew.databinding.ActivityNextBinding;
import com.example.samplefornew.model.MainTaskModel;

public class NextActivity extends AppCompatActivity {
    public String formData = "";
    ActivityNextBinding nextActivityDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        formData = formData + "is Open: " + getIntent().getBooleanExtra("isOpen", false) +
                "\n" + getIntent().getStringExtra("sDate") +
                "\n" + getIntent().getStringExtra("sTime") +
                "\n" + getIntent().getStringExtra("eDate") +
                "\n" + getIntent().getStringExtra("eTime") +
                "\n" + getIntent().getIntExtra("priority", 0) +
                "\n" + getIntent().getStringExtra("notes");

        nextActivityDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_next);
        nextActivityDataBinding.setActivity(this);
    }
}
