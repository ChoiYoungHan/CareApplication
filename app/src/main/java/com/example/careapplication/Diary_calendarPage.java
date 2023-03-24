package com.example.careapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class Diary_calendarPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_calendar_page);

        CalendarView calendarView = findViewById(R.id.Calendar);

        // setOnDateChangeListener는 캘린더에서 날짜가 선택될 때 호출되는 메소드를 등록하는 역할
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            // onSelectedDayChange는 선택된 날짜의 정보를 인자로 전달해주는 역할
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                // 선택된 날짜의 정보가 잘 받아와 지는지 Log로 출력
                Log.d("Tag", "오늘은 " + year + "년 " + (month + 1) + "월 " + day + "일 입니다.");
            }
        });
    }
}