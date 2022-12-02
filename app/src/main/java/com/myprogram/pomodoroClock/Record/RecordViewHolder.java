package com.myprogram.pomodoroClock.Record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myprogram.pomodoroClock.R;

import java.util.Locale;

// 控制显示
public class RecordViewHolder extends RecyclerView.ViewHolder {
    private final TextView recordItemName;
    private final TextView recordItemDuration;
    private final TextView recordItemCount;

    public RecordViewHolder(@NonNull View itemView) {
        super(itemView);
        recordItemName = itemView.findViewById(R.id.statistics_recyclerview_item_name);
        recordItemDuration = itemView.findViewById(R.id.statistics_recyclerView_item_duration);
        recordItemCount = itemView.findViewById(R.id.statistics_recyclerview_item_count);
    }

    public void bind(Record record) {
        recordItemName.setText(record.getName());
        recordItemDuration.setText(record.getDurationStr());
        recordItemCount.setText(String.format(Locale.CHINA, "%d", record.getTimes()));
        recordItemCount.append("次");
    }

    static RecordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistics_recyclerview_item, parent, false);
        return new RecordViewHolder(view);
    }
}
