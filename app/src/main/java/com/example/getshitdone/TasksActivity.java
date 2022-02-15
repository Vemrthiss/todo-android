package com.example.getshitdone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.getshitdone.models.Todo;

import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends AppCompatActivity {
    private Button createTaskBtn;
    private TasksViewModel vm;
    private TodoAdapter adapter;
    private List<Todo> todoList = new ArrayList<>();

    private class tasksCallback implements Observer<List<Todo>> {
        @Override
        public void onChanged(List<Todo> todos) {
            // update UI on task list change
            Log.d("TasksActivity", "todos list updated");
            Log.d("TasksActivity", todos.toString());
            adapter.updateLocalData(todos);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        createTaskBtn = findViewById(R.id.createTaskBtn);
        createTaskBtn.setOnClickListener(createTaskBtnClickListener());

        vm = new ViewModelProvider(this).get(TasksViewModel.class);
        vm.getTasks().observe(this, new tasksCallback());

        // setup RecyclerView
        RecyclerView tasksRecyclerView = findViewById(R.id.tasksList);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TodoAdapter(todoList);
        tasksRecyclerView.setAdapter(adapter);
    }

    private View.OnClickListener createTaskBtnClickListener() {
        return v -> {
            vm.createDefaultTasks();
        };
    }
}