package com.myprogram.pomodoroClock.Record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myprogram.pomodoroClock.R;

// 控制显示
public class RecordViewHolder extends RecyclerView.ViewHolder {
    private final TextView recordItemView;

    public RecordViewHolder(@NonNull View itemView) {
        super(itemView);
        recordItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(Record record) {
        recordItemView.setText(record.toString());
    }

    static RecordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistics_recyclerview_item, parent, false);
        return new RecordViewHolder(view);
    }
}
