package com.example.todolist;

import android.content.DialogInterface;
import android.os.Bundle;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kotlinx.coroutines.scheduling.Task;

public class MainActivity extends AppCompatActivity {
    public ArrayList<TaskModel> TaskList = new ArrayList<>();
    public TaskModel TestTask = new TaskModel("DO NOT FUCK UP");
    MaterialButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.TaskView);
        TaskList.add(TestTask);
        Task_RecyclerViewAdapter adapter = new Task_RecyclerViewAdapter(this,TaskList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MaterialButton button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.taskinputalert,null);

                TextInputEditText editText = view1.findViewById(R.id.editText);

                AlertDialog dialog = new MaterialAlertDialogBuilder(MainActivity.this)
                    .setTitle("Enter Task")
                    .setView(view1)
                        .setPositiveButton("ADD",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog,int i)
                            {
                                if(editText.getText().toString().isEmpty())
                                {
                                    dialog.dismiss();
                                }
                                else
                                {
                                    TaskList.add(new TaskModel(editText.getText().toString()));
                                }
                                dialog.dismiss();
                            }
                        }).create();

                dialog.show();
            }
        });

    }

}