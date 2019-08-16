package com.example.feedbackapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class select_opt extends AppCompatActivity {

    Button student_btn, teacher_btn;
    Intent i1, i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_opt);

        i1 = new Intent(this, Registartion_stu.class);
        i2 = new Intent(this, Registration_teacher.class);

        student_btn = (Button) findViewById(R.id.student_sel);
        student_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i1);
            }
        });

        teacher_btn = (Button) findViewById(R.id.teacher_sel);
        teacher_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i2);
            }
        });
    }
}
