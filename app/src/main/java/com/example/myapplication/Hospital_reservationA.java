package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Hospital_reservationA extends AppCompatActivity {

    //test message

    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_reservation_a);

        Button btndateselect = findViewById(R.id.date_resv); //나의건강수치 버튼 객체

        btndateselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:병원예약 설정 띄움
                showDialog();
            }
        });
    }

    public void OnClickHandler(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] items = getResources().getStringArray(R.array.LAN);  //value -> strings.xml에 내가 쓸 배열 들 저장해주기ㅠOㅠ
        final ArrayList<String> selectedItems = new ArrayList<String>();

        builder.setTitle("사전증상");

        builder.setMultiChoiceItems(R.array.LAN, null, new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int pos, boolean isChecked)
            {
                if(isChecked == true) // Checked 상태일 때 추가
                {
                    selectedItems.add(items[pos]);
                }
                else				  // Check 해제 되었을 때 제거
                {
                    selectedItems.remove(pos);
                }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int pos)
            {
                String SeletedItemsString = "";

                for(int i =0; i<selectedItems.size();i++)
                {
                    SeletedItemsString =  SeletedItemsString + "," + selectedItems.get(i);
                }

                Toast toast = Toast.makeText(getApplicationContext(), "선택 된 항목은 :" + SeletedItemsString,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(getApplicationContext(), "Cancel Click", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void showDialog(){

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                Toast.makeText(getApplicationContext(), year + "년" +
                        month + "월" + dayOfMonth + "일", Toast.LENGTH_SHORT).show();

                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                showDialog2();
            }
        }, 2021, 0, 26);

        datePickerDialog.setTitle("DatePickerDialog");
        datePickerDialog.setMessage("예약 날짜를 선택하세요.");
        datePickerDialog.show();
    }

    public void showDialog2() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(), hourOfDay + "시" +
                        minute + "분", Toast.LENGTH_SHORT).show();

                calendar.set(Calendar.HOUR, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);

                Intent intent = new Intent(getApplicationContext(), Hospital_reservationA.class);
                startActivity(intent);

            }
        }, 1, 51,  DateFormat.is24HourFormat(this)); //true=24시간 선택 다이얼로그로 설정(13시부터 작은숫자로 나옴)
                                                                        // DateFormat.is24HourFormat(this) = AM, PM으로 나뉘어서 시간나옴

        timePickerDialog.setTitle("TimePickerDialog");
        timePickerDialog.setMessage("시간을 선택하세요.");
        timePickerDialog.show();
    }


}
