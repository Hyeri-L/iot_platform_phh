package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PatientMainA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_main);
        Button btn_med = findViewById(R.id.btn_Medication);//약 복용 알림 버튼 객체
        Button btneme = findViewById(R.id.emergancy); //긴급신고 버튼 객체
        Button btnmystate = findViewById(R.id.my_state); //나의건강수치 버튼 객체
        Button btnresv = findViewById(R.id.hospital_resv); //병원예약 버튼 객체

        btneme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:서버로 환자 긴급상태 보내기
                Toast.makeText(getApplicationContext(),"긴급신호 전송 완료",Toast.LENGTH_LONG).show();
            }
        });
        btn_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:메인페이지에서 약 복용 알림 페이지로 화면전환
                Intent intent = new Intent(getApplicationContext(), MedicationReminderA.class);
                startActivity(intent);
            }
        });
        btnresv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:메인페이지에서 병원예약 페이지로 화면전환
                Intent intent = new Intent(getApplicationContext(), Hospital_reservationA.class);
                startActivity(intent);
            }
        });
        btnmystate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:메인페이지에서 나의 건강수치 페이지로 화면전환
                Intent intent = new Intent(getApplicationContext(),  PatientstateA.class);
                startActivity(intent);
            }
        });
    }
     /* 각 버튼을 누르면 화면을 이동시킬 인텐트 입니다.
    public void go1(View view) {
        Intent intent = new Intent(this, .class);
        startActivity(intent);
        finish();
    }
    public void go2(View view) {
        Intent intent = new Intent(this, .class);
        startActivity(intent);
        finish();
    }*/
}