package com.myprogram.pomodoroClock.Record;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.myprogram.pomodoroClock.R;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RecordDialog extends DialogFragment {
    private Record record;
    RecordDialogListener listener;

    public interface RecordDialogListener {
        public void onDialogPositiveClick(RecordDialog dialog);

        public void onDialogNegativeClick(RecordDialog dialog);
    }

    public RecordDialog(Record record) {
        this.record = record;
    }

    public Record getRecord() {
        return record;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (RecordDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement RecordDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = View.inflate(getActivity(), R.layout.dialog_record, null);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(record.getDate());
        String startStr = "" + calendar.get(Calendar.YEAR) + "-" + (1 + calendar.get(Calendar.MONTH))
                + "-" + calendar.get(Calendar.DAY_OF_MONTH)
                + " " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        TextView startTimeTV = view.findViewById(R.id.layout_textview_start_time_value);
        startTimeTV.setText(startStr);
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + record.getDuration());
        String endStr = "" + calendar.get(Calendar.YEAR) + "-" + (1 + calendar.get(Calendar.MONTH))
                + "-" + calendar.get(Calendar.DAY_OF_MONTH)
                + " " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        TextView endTimeTV = view.findViewById(R.id.layout_textview_end_time_value);
        endTimeTV.setText(endStr);
        TextView durationTimeTV = view.findViewById(R.id.layout_textview_duration_value);
        durationTimeTV.setText(integerToTime(record.getDuration()));
        TextView countsTimeTV = view.findViewById(R.id.layout_textview_times_value);
        countsTimeTV.setText(String.format(Locale.CHINA, "%d次", record.getTimes()));

        builder.setView(view);
        builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogPositiveClick(RecordDialog.this);
                Toast.makeText(getContext(),
                        "删除",
                        Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogNegativeClick(RecordDialog.this);
                Toast.makeText(getContext(),
                        "取消",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }

    String integerToTime(Integer integer) {
        String str = "";
        if (integer == null)
            integer = 0;
        int t = integer;
        int h = t / 60, m = t % 60;
        if (h != 0)
            str = h + "时";
        str += m + "分";
        return str;
    }
}
