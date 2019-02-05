package com.csit551.android.gpa_perezm42_calculator;


import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private Button mGPAButton;
    private TextView mGPATextView;
    private static final String KEY_INDEX = "index";
    private static final String KEY_INDEX1 = "index1";
    private static final String KEY_INDEX2 = "index2";
    private int color_code=0;
    private LinearLayout lLoyout;
    private String current_result="";
    private String current_btnText="";
    private int getColor_code=0;
    private static DecimalFormat gpar = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGPATextView = findViewById(R.id.txGPS);
        mGPAButton = findViewById(R.id.bnGPS);
        lLoyout=findViewById(R.id.layoutP);

        if (savedInstanceState != null) {
            current_result= savedInstanceState.getString(KEY_INDEX);
            current_btnText=savedInstanceState.getString(KEY_INDEX1);
            getColor_code=savedInstanceState.getInt(KEY_INDEX2);
            mGPATextView.setText(current_result);
            mGPAButton.setText(current_btnText);
            if (getColor_code==1){
                lLoyout.setBackgroundColor(Color.GREEN);
            }
            else if(getColor_code==2){
                lLoyout.setBackgroundColor(Color.YELLOW);
            }
            else if(getColor_code==3){
                lLoyout.setBackgroundColor(Color.RED);
            }
            else{
                lLoyout.setBackgroundColor(Color.WHITE);
            }

        }

        final EditText G1 = findViewById(R.id.getg1);  // declare all five buttons
        final EditText G2 = findViewById(R.id.getg2);
        final EditText G3 = findViewById(R.id.getg3);
        final EditText G4 = findViewById(R.id.getg4);
        final EditText G5 = findViewById(R.id.getg5);

        G1.addTextChangedListener(new TextWatcher() {  // textwatchers for each edittext to change button text when user change text
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean userChange = Math.abs(count - before) == 1;
                if (userChange) {
                    mGPAButton.setText(R.string.calculateGPS);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        G2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean userChange = Math.abs(count - before) == 1;
                if (userChange) {
                    mGPAButton.setText(R.string.calculateGPS);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        G3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean userChange = Math.abs(count - before) == 1;
                if (userChange) {
                    mGPAButton.setText(R.string.calculateGPS);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        G4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean userChange = Math.abs(count - before) == 1;
                if (userChange) {
                    mGPAButton.setText(R.string.calculateGPS);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        G5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean userChange = Math.abs(count - before) == 1;
                if (userChange) {
                    mGPAButton.setText(R.string.calculateGPS);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        mGPAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  // button listerner that call update_result method
               update_result(G1,G2,G3,G4,G5);
               mGPAButton.setText(R.string.Clear);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY_INDEX, mGPATextView.getText().toString());
        savedInstanceState.putString(KEY_INDEX1,mGPAButton.getText().toString());
        savedInstanceState.putInt(KEY_INDEX2,color_code);
    }


    private void update_result(EditText G1, EditText G2, EditText G3, EditText G4, EditText G5) { // method that does all the cheking and operations

            String[] grade= new String[5];
            int count_grade=0;
            double total=0;
            double gpa=0;
            String message, message1, message2;

            grade[0]=G1.getText().toString().trim();
            grade[1]=G2.getText().toString().trim();
            grade[2]=G3.getText().toString().trim();
            grade[3]=G4.getText().toString().trim();
            grade[4]=G5.getText().toString().trim();

            message2="Empty grade field ";
            message="Wrong Grade value entered ";
            message1=" (correct values, A, A-, B+, B, B-, C+, C, C-, D+, D, D-)";


            for( int i=0; i <=4; i++){

              if(grade[i].length()>0) {

                  if (grade[i].equals("A")) {
                      total = total + (4.0 * 3.0);
                      count_grade += 1;
                  } else if (grade[i].equals("A-")) {
                      total = total + (3.7 * 3.0);
                      count_grade += 1;
                  } else if (grade[i].equals("B+")) {
                      total = total + (3.33 * 3.0);
                      count_grade += 1;
                  }
                  else if (grade[i].equals("B")) {
                      total = total + (3.0 * 3.0);
                      count_grade += 1;
                  }
                  else if (grade[i].equals("B-")) {
                      total = total + (2.7 * 3.0);
                      count_grade += 1;
                  }
                  else if (grade[i].equals("C+")) {
                      total = total + (2.3 * 3.0);
                      count_grade += 1;
                  }
                  else if (grade[i].equals("C")) {
                      total = total + (2.0 * 3.0);
                      count_grade += 1;
                  }
                  else if (grade[i].equals("C-")) {
                      total = total + (1.7 * 3.0);
                      count_grade += 1;
                  }
                  else if (grade[i].equals("D+")) {
                      total = total + (1.3 * 3.0);
                      count_grade += 1;
                  }
                  else if (grade[i].equals("D")) {
                      total = total + (1.0 * 3.0);
                      count_grade += 1;
                  }
                  else if (grade[i].equals("D-")) {
                      total = total + (0.70 * 3.0);
                      count_grade += 1;
                  }
                  else{
                      message=message +"/G"+(i+1);
                  }
              }
              else {
                     message2= message2 + "/G"+ (i+1);


              }

            }

            if (message!="Wrong Grade value entered ") {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            Toast.makeText(this, message1, Toast.LENGTH_LONG).show();
            }
            if(message2!="Empty grade field ") {
                Toast.makeText(this, message2, Toast.LENGTH_LONG).show();
            }
            if(count_grade==5){
                gpa=total/15;
                mGPATextView.setText(String.valueOf(gpar.format(gpa)));
            }

            if(gpa>=2.67) {                                    // gpa >= 2.67 or between 80 to 100
                color_code=1;
                lLoyout.setBackgroundColor(Color.GREEN);
            } else if(gpa>=1.0){                              // gpa >= 1 or between 61 to 79
                color_code=2;
                lLoyout.setBackgroundColor(Color.YELLOW);
            } else if(gpa>0) {                                          // else less than 60
                color_code=3;
                lLoyout.setBackgroundColor(Color.RED);
            }
}




}
