package com.example.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

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
        View view1 = LayoutInflater.from(adapter.context).inflate(R.layout.taskinputalert,null);
        TextInputEditText editText = view1.findViewById(R.id.editText);
        final int position = viewHolder.getAdapterPosition();
        if(direction == ItemTouchHelper.LEFT)
        {
            androidx.appcompat.app.AlertDialog builder = new MaterialAlertDialogBuilder(adapter.context)
            .setTitle("Delete Task")
            .setMessage("Are you sure")
            .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int i)
                {
                    adapter.deleteItem(position);
                }
            })
            .setNegativeButton("No",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int i)
                {
                    adapter.notifyItemChanged(position);
                    dialog.dismiss();
                }
            }).create();
            builder.show();
        }
        else
        {
            androidx.appcompat.app.AlertDialog dialog = new MaterialAlertDialogBuilder(adapter.context)
            .setTitle("Change task name")
            .setView(view1)
            .setPositiveButton("Change",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog,int i)
                {
                    if(!editText.getText().toString().isEmpty())
                    {
                        adapter.editItem(position,editText.getText().toString());
                    }
                    adapter.notifyItemChanged(position);
                    dialog.dismiss();
                }
                })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    adapter.notifyItemChanged(position);
                }
                    }).create();
            dialog.show();
        }
    }
}
