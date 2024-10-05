package com.example.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ViewTouchHelper extends ItemTouchHelper.SimpleCallback{
    private Task_RecyclerViewAdapter adapter;
    public ViewTouchHelper(Task_RecyclerViewAdapter adapter)
    {
        super(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
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
            builder.setTitle("Delete Task");
            builder.setMessage("Are you sure");
            builder.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int i)
                {
                    adapter.deleteItem(position);
                }
            });
            builder.setNegativeButton("No",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int i)
                {
                    adapter.notifyItemChanged(position);
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else
        {
            adapter.editItem(position);
            AlertDialog.Builder builder = new AlertDialog.Builder(adapter.context);
            builder.setTitle("works");

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

}
