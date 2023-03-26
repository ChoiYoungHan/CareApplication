package com.example.careapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiaryPage extends AppCompatActivity {

    // TextView를 사용하기 위한 변수 선언
    private TextView Tv_Date;

    // Button을 사용하기 위한 변수 선언
    private Button Btn_GetImage;

    // 갤러리에서 이미지를 선택하는 요청에 대한 결과를 식별하기 위한 상수값 선언
    // 상수값은 아무 숫자나 상관이 없지만, 요청 코드가 다른 코드에서 중복되지 않도록 해야한다.
    private static final int REQUEST_CODE_PICK_IMAGE = 100;

    // 갤러리에서 사진을 가져오기 위한 메소드
    private void pickImage() {
        // 갤러리 호출하는 intent 생성 (ACTION_GET_CONTENT는 안드로이드에서 파일을 선택하고 불러오는 데 사용하는 상수이다)
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*"); // 선택 가능한 파일의 종류를 image로 한다.
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); // 여러 개의 이미지를 선택할 수 있도록 EXTRA_ALLOW_MULTIPLE을 true 로 설정

        // startActivityForResult의 경우 최신 버전이 나옴에 따라 사용이 권장되지 않음
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_page); // activity_diary.xml에 설정된 View들을 가져옴

        // activity_diary.xml에서 설정된 View를 가져와서 정의
        Tv_Date = findViewById(R.id.Tv_Date);

        Btn_GetImage = findViewById(R.id.Btn_GetImage);

        // Diary_calendarPage에서 전달받은 데이터 추출
        Bundle bundle = getIntent().getExtras();
        int year = bundle.getInt("year");
        int month = bundle.getInt("month");
        int day = bundle.getInt("day");

        Tv_Date.setText(year + "년 " + month + "월 " + day + "일");

        Btn_GetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage();
            }
        });


    }
}