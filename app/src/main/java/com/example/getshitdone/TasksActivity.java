package com.example.getshitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TasksActivity extends AppCompatActivity {
    private Button createTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        createTaskBtn = findViewById(R.id.createTaskBtn);
        createTaskBtn.setOnClickListener(createTaskBtnClickListener());
    }

    private View.OnClickListener createTaskBtnClickListener() {
        return v -> {
            Log.d("TasksActivity", "submitting");
        };
    }
}