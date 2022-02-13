package com.example.getshitdone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * navigates to task activity
     * @param view
     */
    public void goToTasks(View view) {
        // create explicit intent to activate the task activity
        Intent activateTasksIntent = new Intent(this, TasksActivity.class);
        startActivity(activateTasksIntent);
    }
}