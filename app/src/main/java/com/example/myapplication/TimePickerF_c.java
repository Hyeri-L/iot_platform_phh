package com.example.myapplication;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerF_c extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private AlarmManager mAlarmManager;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {//아침시간 입력 받아 TimePickerDialog
        mAlarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getContext(), this, hour, minute, DateFormat.is24HourFormat(getContext()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        updateTimeText(calendar);
        Intent intent = new Intent(getContext(), AlertReceiver_c.class);//동작안함
        PendingIntent operation = PendingIntent.getBroadcast(getContext(), 3, intent, 0);
        if(calendar.before((Calendar.getInstance()))){
            calendar.add(Calendar.DATE, 1);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //mAlarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), operation3);
            mAlarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1*60*1000 , operation);
            System.out.println("onTimeSet 성공");
        }

    }

    public void updateTimeText(Calendar c) {
        String timeText = java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT).format(c.getTime()); //DateFormat.SHORT 03:33PM 형식
        TextView mTextView = getActivity().findViewById(R.id.dinertime);
        mTextView.setText(timeText);
    }
}
