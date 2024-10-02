package com.example.todolist;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ViewTouchHelper extends ItemTouchHelper.SimpleCallback{
    private Task_RecyclerViewAdapter adapter;
    public ViewTouchHelper(Task_RecyclerViewAdapter adapter)
    {
        super(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
    }
    @Override
    public boolean onMove(RecyclerView recyclerView,RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target)
    {

    }
}
