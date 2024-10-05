package com.example.todolist;

import android.app.AlertDialog;

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
        return false;
    }
    @Override
    public void onSwiped(final RecyclerView.ViewHolder viewHolder,int direction)
    {
        final int position = viewHolder.getAdapterPosition();
        if(direction == ItemTouchHelper.LEFT)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(adapter.context);
                builder.setTitle("works").create()

            builder.show()
        }
    }

}
