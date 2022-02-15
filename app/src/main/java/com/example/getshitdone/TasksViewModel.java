package com.example.getshitdone;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.getshitdone.data.TodoRepository;
import com.example.getshitdone.models.Todo;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TasksViewModel extends ViewModel {
    private static final String TAG = "TasksViewModel";
    private MutableLiveData<List<Todo>> tasks;
    private final TodoRepository todoRepository = new TodoRepository();
    public LiveData<List<Todo>> getTasks() {
        if (tasks == null) {
            tasks = new MutableLiveData<>();
            loadTasks();
        }
        return tasks;
    }

    private void loadTasks() {
        // todoRepository.getAllTasks();
        todoRepository.getTasksCollection().addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w(TAG, "Listen failed.", error);
                    return;
                }

                List<Todo> newTasks = new ArrayList<>();
                for (QueryDocumentSnapshot document : value) {
                    Map<String, Object> rawData = document.getData();
                    Log.d(TAG, document.getId() + " => " + rawData  + " LISTENER");
                    newTasks.add(new Todo(rawData));
                }
                tasks.setValue(newTasks);
            }
        });
    }

    public void createDefaultTasks() {
        todoRepository.createDefaultTask();
    }

    public void createNamedTask(String name) {
        todoRepository.createNamedTask(name);
    }
}
