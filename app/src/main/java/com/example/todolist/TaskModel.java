package com.example.todolist;


public class TaskModel {
    String TaskName;
    public TaskModel(String TaskName)
    {
        this.TaskName = TaskName;
    }
    public String getTaskName()
    {
        return TaskName;
    }
    public String DeleteTaskName(){return TaskName = "";}
    public void SetTaskName(String Change){TaskName = Change;}
}
