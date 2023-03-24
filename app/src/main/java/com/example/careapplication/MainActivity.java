package com.example.careapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // MainActivity에서 사용할 변수 선언
    private Button Btn_Calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_main_xml에 설정된 View들을 가져와서 정의 ( 버튼 )
        Btn_Calendar = findViewById(R.id.Btn_Calendar);

        Btn_Calendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Diary_calendarPage.class);
                startActivity(intent);
            }
        });
    }
}