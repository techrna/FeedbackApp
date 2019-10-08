package com.example.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration_teacher extends AppCompatActivity {
    EditText tname,tmail,tmn,tuid,tdoj;
    Button btsubmit;
    DatabaseReference reff;
    Register member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_teacher);
        tname=(EditText)findViewById(R.id.Tname);
        tmail=(EditText)findViewById(R.id.Temail);
        tmn=(EditText)findViewById(R.id.Tmn);
        tuid=(EditText)findViewById(R.id.Tuid);
        tdoj=(EditText) findViewById(R.id.tdoj);
        btsubmit=(Button)findViewById(R.id.btsubmit);

        member=new Register();
        reff = FirebaseDatabase.getInstance().getReference().child("teachers");
        btsubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                member.setName(tname.getText().toString().trim());
                member.setMail(tmail.getText().toString().trim());
                member.setMn(tmn.getText().toString().trim());
                member.setUid(tuid.getText().toString().trim());
                member.setDoj(tdoj.getText().toString().trim());
                reff.push().setValue(member);
                Toast.makeText(Registration_teacher.this, "Data Inserted Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }
}

