package com.example.feedbackapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registartion_stu extends AppCompatActivity {

    static final String[] streamArray = new String[]{"Stream", "MCA", "MMS"};
    static final String[] yearArray = new String[]{"Year","I", "II","III"};
    static final String[] gendersArray = new String[]{"Gender","Male", "Female"};
    static final String[] batchArray = new String[]{"Year","2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008"};


    FirebaseDatabase firebase;
    DatabaseReference databaseReference;


    public static final String Database_Path = "Student_Details_Database";



    EditText etname,etemailid,etmobileno,etaddress,etrollno;
    Spinner spgender,spstream,spstreamyear,spbstart,spbend;
    Button btsubmit;
    String name,email,mobileno,address,gender,stream,year,rollno,bstart,bend;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registartion_stu);



        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference("registration");





        etname=(EditText)findViewById(R.id.etname);
        etemailid=(EditText)findViewById(R.id.etemail);
        etmobileno=(EditText)findViewById(R.id.etmobileno);
        etaddress=(EditText)findViewById(R.id.etaddress);
        etrollno=(EditText)findViewById(R.id.etrollno);


        spgender=(Spinner) findViewById(R.id.spgender);
        spstream=(Spinner) findViewById(R.id.spstream);
        spstreamyear=(Spinner) findViewById(R.id.spstreamYear);
        spbstart=(Spinner) findViewById(R.id.spbstart);
        spbend=(Spinner) findViewById(R.id.spbend);

        btsubmit=(Button)findViewById(R.id.btsubmit);









        //stream spinner Data

        ArrayAdapter<String> streamsArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, streamArray );
        streamsArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spstream);
        spinner.setAdapter(streamsArray);
        spinner.setSelection(0);



        // year spinner Data

        ArrayAdapter<String> streamYearArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,yearArray);
        streamYearArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner1 = (Spinner) findViewById(R.id.spstreamYear);
        spinner1.setAdapter(streamYearArray);
        spinner1.setSelection(0);



        // gender spinner Data

        ArrayAdapter<String> genderArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,gendersArray);
        genderArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner2 = (Spinner) findViewById(R.id.spgender);
        spinner2.setAdapter(genderArray);
        spinner2.setSelection(0);


        // start year spinner Data
        ArrayAdapter<String> startYearArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,batchArray);
        startYearArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner3 = (Spinner) findViewById(R.id.spbstart);
        spinner3.setAdapter(startYearArray);
        spinner3.setSelection(0);


        // end year spinner Data
        ArrayAdapter<String> endYearArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,batchArray);
        endYearArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner4 = (Spinner) findViewById(R.id.spbend);
        spinner4.setAdapter(startYearArray);
        spinner4.setSelection(0);


        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reg_stu_data stu_details=new reg_stu_data();

                getRegData();

                stu_details.setAddress(address);
                stu_details.setBend(bend);
                stu_details.setBstart(bstart);
                stu_details.setEmail(email);
                stu_details.setGender(gender);
                stu_details.setMobileno(mobileno);
                stu_details.setName(name);
                stu_details.setRollno(rollno);
                stu_details.setStream(stream);
                stu_details.setYear(year);

                String newUID=databaseReference.push().getKey();

                databaseReference.child(newUID).setValue(stu_details);

                Toast.makeText(Registartion_stu.this,"Register Successfully ", Toast.LENGTH_LONG).show();


            }
        });



    }


    private void  getRegData()
    {
        name=etname.getText().toString();
        email=etemailid.getText().toString();
        mobileno=etmobileno.getText().toString();
        address=etaddress.getText().toString();
        rollno=etrollno.getText().toString();

        gender=spgender.getSelectedItem().toString();
        stream=spstream.getSelectedItem().toString();
        year=spstreamyear.getSelectedItem().toString();
        bstart=spbstart.getSelectedItem().toString();
        bend=spbend.getSelectedItem().toString();

    }



}