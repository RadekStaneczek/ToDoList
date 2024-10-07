package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Task_RecyclerViewAdapter extends RecyclerView.Adapter<Task_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<TaskModel> TaskList;
    public Task_RecyclerViewAdapter(Context context,ArrayList<TaskModel> TaskList)
    {
        this.context = context;
        this.TaskList = TaskList;
    }

    @NonNull
    @Override
    public Task_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.task_layout,parent,false);
        return new Task_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Task_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.TaskName.setText(TaskList.get(position).getTaskName());
    }

    @Override
    public int getItemCount() {
        return TaskList.size();
    }


    public void deleteItem(int position)
    {
        TaskList.remove(position);
        notifyItemRemoved(position);
    }
    public void editItem(int position,String NewTaskName)
    {
        TaskList.get(position).SetTaskName(NewTaskName);
        notifyItemChanged(position);
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CheckBox TaskName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TaskName = itemView.findViewById(R.id.todoCheckBox);
        }
    }
}
