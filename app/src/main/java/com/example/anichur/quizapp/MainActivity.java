package com.example.anichur.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup1,radioGroup2;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8;
    Button check_answer;
    int correct_answers;
    TextView out1,out2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_views();
        init_variables();
        init_listener();
        init_function();
    }

    private void init_variables() {
        correct_answers = 0;
    }

    private void init_views() {

        radioGroup1 = (RadioGroup)findViewById(R.id.RG1_one);
        radioGroup2 = (RadioGroup)findViewById(R.id.RG_TWO);
        rb1 = (RadioButton)findViewById(R.id.RG1_OPA);
        rb2 = (RadioButton)findViewById(R.id.RG1_OPB);
        rb3 = (RadioButton)findViewById(R.id.RG1_OPC);
        rb4 = (RadioButton)findViewById(R.id.RG1_OPD);
        rb5 = (RadioButton)findViewById(R.id.RG2_OPA);
        rb6 = (RadioButton)findViewById(R.id.RG2_OPB);
        rb7 = (RadioButton)findViewById(R.id.RG2_OPC);
        rb8 = (RadioButton)findViewById(R.id.RG2_OPD);
        check_answer = (Button)findViewById(R.id.submit);
        out1 = (TextView)findViewById(R.id.textView1);
    }

    private void init_listener(){

                radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        if(radioGroup1.getCheckedRadioButtonId() == rb3.getId())
                            ++correct_answers;
                        else if(correct_answers > 0){
                            --correct_answers;
                        }
                    }
                });

                radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if(radioGroup2.getCheckedRadioButtonId() == rb7.getId())
                            ++correct_answers;
                        else if(correct_answers > 0){
                            --correct_answers;
                        }
                    }
                });

                check_answer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int checked1 = radioGroup1.getCheckedRadioButtonId();
                        int checked2 = radioGroup2.getCheckedRadioButtonId();

                        if(checked1 == rb3.getId()) {
                            rb3.setTextColor(Color.GREEN);
                        }
                        else
                        {
                            RadioButton ans = (RadioButton)findViewById(checked1);
                            ans.setTextColor(Color.RED);
                        }

                        if(checked2 == rb7.getId()){
                            rb7.setTextColor(Color.GREEN);
                        }
                        else
                        {
                            RadioButton ans = (RadioButton)findViewById(checked2);
                            ans.setTextColor(Color.RED);
                        }

                        radioGroup1.clearCheck();
                        radioGroup2.clearCheck();

                        Toast.makeText(getApplicationContext(),"Number of correct answer : " + correct_answers,Toast.LENGTH_SHORT);
                        correct_answers = 0;
                    }
                });
            }


    private void init_function(){

    }
}
