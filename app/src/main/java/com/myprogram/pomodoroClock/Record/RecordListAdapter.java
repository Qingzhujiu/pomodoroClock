package com.myprogram.pomodoroClock.Record;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class RecordListAdapter extends ListAdapter<Record, RecordViewHolder> {
    private FragmentManager fm;

    public void setFm(FragmentManager fm) {
        this.fm = fm;
    }

    public RecordListAdapter(@NonNull DiffUtil.ItemCallback<Record> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecordViewHolder holder = RecordViewHolder.create(parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        Record current = getItem(position);
        holder.bind(current);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecordDialog recordDialog = new RecordDialog(current);
                recordDialog.show(fm, "recordDialog");
            }
        });
    }


    public static class RecordDiff extends DiffUtil.ItemCallback<Record> {

        @Override
        public boolean areItemsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
            return oldItem.getId() == newItem.getId()
                    && oldItem.getDate().equals(newItem.getDate())
                    && oldItem.getType().equals(newItem.getType())
                    && oldItem.getName().equals(newItem.getName())
                    && oldItem.getDuration() == newItem.getDuration()
                    && oldItem.getTimes() == newItem.getTimes();
        }
    }

}
