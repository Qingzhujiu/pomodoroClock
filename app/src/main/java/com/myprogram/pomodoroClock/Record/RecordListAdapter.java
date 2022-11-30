package com.myprogram.pomodoroClock.Record;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class RecordListAdapter extends ListAdapter<Record, RecordViewHolder> {
    public RecordListAdapter(@NonNull DiffUtil.ItemCallback<Record> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RecordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        Record current = getItem(position);
        holder.bind(current);
    }

    public static class RecordDiff extends DiffUtil.ItemCallback<Record> {

        @Override
        public boolean areItemsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
            return oldItem.getId() == newItem.getId()
                    && oldItem.getSqlDate().equals(newItem.getSqlDate())
                    && oldItem.getType().equals(newItem.getType())
                    && oldItem.getName().equals(newItem.getName())
                    && oldItem.getDuration() == newItem.getDuration()
                    && oldItem.getTimes() == newItem.getTimes();
        }
    }

}
