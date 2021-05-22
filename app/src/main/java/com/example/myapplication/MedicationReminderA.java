package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MedicationReminderA extends AppCompatActivity {
private TextView mTextView;
int i = 1;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_reminder);

        Button buttonm = (Button) findViewById(R.id.button_timepicker_m);//아침 약 알림 시간 변경
        buttonm.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
                DialogFragment timePicker = new TimePickerF_a();
                timePicker.show(getSupportFragmentManager(), "time picker_1");
                }

                });

                Button buttonCancelAlarm = findViewById(R.id.button_cancel);
                buttonCancelAlarm.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v) {
               // cancelAlarm();
                }
                });

        Button buttonl = (Button) findViewById(R.id.button_timepicker_l);//점심 약 알림 시간 변경
        buttonl.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                        DialogFragment timePicker = new TimePickerF_b();
                        timePicker.show(getSupportFragmentManager(), "time picker_2");
                }

        });

        Button buttond = (Button) findViewById(R.id.button_timepicker_d);//저녁 약 알림 시간 변경
        buttond.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                        DialogFragment timePicker = new TimePickerF_c();
                        timePicker.show(getSupportFragmentManager(), "time picker_3");
                }

        });
        }

        }