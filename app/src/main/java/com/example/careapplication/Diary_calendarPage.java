package com.example.careapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class Diary_calendarPage extends AppCompatActivity {

    private long ClickTime = 0; // 캘린더에서 첫 번째로 클릭한 시간을 저장할 변수 선언
    private int before_Year, before_Month, before_Day; // 캘린더에서 첫 번째로 클릭한 날짜의 값을 저장할 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_calendar_page); // activity_diary_calendar.xml에서 설정된 View들을 가져옴

        // activity_diary_calendar.xml에서 설정된 View들을 가져와서 정의
        CalendarView calendarView = findViewById(R.id.Calendar);

        // setOnDateChangeListener는 캘린더에서 날짜가 선택될 때 호출되는 메소드를 등록하는 역할
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            // onSelectedDayChange는 선택된 날짜의 정보를 인자로 전달해주는 역할
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                long now = System.currentTimeMillis(); // 현재 시간을 가져와서 now에 저장

                // 이전에 클릭한 날짜와 현재 클릭한 날짜의 값을 비교하여 일치하는지 확인
                if(before_Year == year && before_Month == month && before_Day == day){
                    if(now - ClickTime < 500){ // 500ms(0.5초) 이내에 다시 클릭되었는지 확인한다.
                        Intent intent = new Intent(Diary_calendarPage.this, DiaryPage.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("year", year);
                        bundle.putInt("month", (month+1));
                        bundle.putInt("day", day);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                } else {
                    before_Year = year;
                    before_Month = month;
                    before_Day = day;
                    ClickTime = now;
                }
            }
        });
    }
}