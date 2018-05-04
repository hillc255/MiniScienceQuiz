package com.example.android.minisciencequiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays a mini science quiz with 4 questions
 */
public class Main2Activity extends AppCompatActivity {

    private RadioGroup radioGroup, radioGroup2;
    private RadioButton radioButton, radioButton2;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    Button submitButton, submitButton4, exitButton;
    TextView textView, textView2, textView3, textView4;
    String finalScoreCount;
    int correctResponse, incorrectResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //Radio button 2 is the correct answer
        radioButton = findViewById(R.id.radioButton2);
        //Display correct answer in this textView
        textView = findViewById(R.id.answer);

        //Sets up radio button group
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //Quiz 1: Set up radio buttons

                //Disable all radio buttons once one is checked
                int max = group.getChildCount();
                for (int i = 0; i < max; i++) {
                    group.getChildAt(i).setEnabled(false);
                }

                RadioButton radiobutton = findViewById(checkedId);
                // Set the checked radio button background color from hex string
                radiobutton.setBackgroundColor(Color.parseColor("#7e7e7e"));
                radiobutton.setTextColor(Color.parseColor("#ffffff"));

                //Determine if radio button selection is correct or incorrect - display response
                if (radioButton.isChecked()) {
                    textView.setText(R.string.quiz1_correct);
                    correctResponse = correctResponse + 1;
                    setCorrectResponse(correctResponse);

                } else {
                    textView.setText(R.string.quiz1_incorrect);
                    incorrectResponse = incorrectResponse + 1;
                    setIncorrectResponse(incorrectResponse);
                }

                //Get and display correct score
                int c = getCorrectResponse();
                int i = getIncorrectResponse();
                TextView scoreTextView = findViewById(R.id.scoreCount);
                scoreTextView.setText(c + " / " + i);
            }
        });


        //Quiz 2: Set up radio buttons

        //Radio button 3 is the correct answer
        radioButton2 = findViewById(R.id.radioButton3b);
        //Display correct answer in this textView
        textView2 = findViewById(R.id.answer2);
        radioGroup2 = findViewById(R.id.radioGroupb);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group2, int checkedId) {
                //Disable all radio buttons once one is checked
                int max = group2.getChildCount();
                for (int i = 0; i < max; i++) {
                    group2.getChildAt(i).setEnabled(false);
                }
                RadioButton radiobutton2 = findViewById(checkedId);
                // Set the checked radio button background color from hex string
                radiobutton2.setBackgroundColor(Color.parseColor("#7e7e7e"));
                radiobutton2.setTextColor(Color.parseColor("#ffffff"));

                //Determine if radio button selection is correct or incorrect - display response
                if (radioButton2.isChecked()) {
                    textView2.setText(R.string.quiz2_correct);
                    correctResponse = getCorrectResponse() + 1;
                    setCorrectResponse(correctResponse);

                } else {
                    textView2.setText(R.string.quiz2_incorrect);
                    incorrectResponse = getIncorrectResponse() + 1;
                    setIncorrectResponse(incorrectResponse);

                }

                //Display correct score
                TextView scoreTextView = findViewById(R.id.scoreCount2);
                scoreTextView.setText(getCorrectResponse() + " / " + getIncorrectResponse());
            }

        });

        //Quiz 3: Display correct answer in this textView from user input

        textView3 = findViewById(R.id.answer3);

        EditText edittext = findViewById(R.id.editTextBox);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final EditText numString = findViewById(R.id.editTextBox);
                String str = numString.getText().toString();

                //Determine if input is correct - display correct response
                if (str.equals("3")) {
                    textView3.setText(R.string.quiz3_correct);
                    correctResponse = correctResponse + 1;
                    submitButton.setEnabled(false);

                } else if (TextUtils.isEmpty(str) || !str.equals("3")) {
                    textView3.setText(R.string.quiz3_incorrect);
                    incorrectResponse = incorrectResponse + 1;
                    submitButton.setEnabled(false);
                }

                //Display correct score
                TextView scoreTextView = findViewById(R.id.scoreCount3);
                scoreTextView.setText(getCorrectResponse() + " / " + getIncorrectResponse());
            }

        });

        //Quiz 4: checkboxes

        //Initiate checkboxes and submit button
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);

        //Create listener for submitButton
        submitButton4 = findViewById(R.id.buttonSubmit4);
        submitButton4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //Display correct answer in this textView
                textView4 = findViewById(R.id.answer4);
                if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()) {

                    //Set the checkbox background color from hex string
                    checkBox1.setBackgroundColor(Color.parseColor("#7e7e7e"));
                    checkBox1.setTextColor(Color.parseColor("#ffffff"));

                    checkBox1.setEnabled(false);
                    checkBox2.setEnabled(false);
                    checkBox3.setEnabled(false);
                    checkBox4.setEnabled(false);
                    submitButton4.setEnabled(false);

                    //correct answer displays
                    textView4.setText(R.string.quiz4_correct);
                    correctResponse = correctResponse + 1;
                    setCorrectResponse(correctResponse);

                } else {
                    //Set the checkbox background color from hex string of all checked checkboxes;
                    if (checkBox1.isChecked()) {
                        checkBox1.setBackgroundColor(Color.parseColor("#7e7e7e"));
                        checkBox1.setTextColor(Color.parseColor("#ffffff"));
                    }
                    if (checkBox2.isChecked()) {
                        checkBox2.setBackgroundColor(Color.parseColor("#7e7e7e"));
                        checkBox2.setTextColor(Color.parseColor("#ffffff"));
                    }
                    if (checkBox3.isChecked()) {
                        checkBox3.setBackgroundColor(Color.parseColor("#7e7e7e"));
                        checkBox3.setTextColor(Color.parseColor("#ffffff"));
                    }
                    if (checkBox4.isChecked()) {
                        checkBox4.setBackgroundColor(Color.parseColor("#7e7e7e"));
                        checkBox4.setTextColor(Color.parseColor("#ffffff"));
                    }
                    checkBox1.setEnabled(false);
                    checkBox2.setEnabled(false);
                    checkBox3.setEnabled(false);
                    checkBox4.setEnabled(false);
                    submitButton4.setEnabled(false);

                    //incorrect answer displays
                    textView4.setText(R.string.quiz4_incorrect);
                    incorrectResponse = incorrectResponse + 1;
                    setIncorrectResponse(incorrectResponse);

                    exitButton.setVisibility(View.VISIBLE);
                }

                //Display correct score
                TextView scoreTextView4 = findViewById(R.id.scoreCount4);
                scoreTextView4.setText(getCorrectResponse() + " / " + getIncorrectResponse());
            }
        });


        //Click End button and assign a listener
        exitButton = findViewById(R.id.clickButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //Toast displays total score and close application
                exitApp();
            }
        });

    }


    /**
     * This method sets the correct responses
     */
    private void setCorrectResponse(int c) {
        correctResponse = c;
    }

    /**
     * This method sets the incorrect response
     */
    private void setIncorrectResponse(int i) {
        incorrectResponse = i;
    }


    /**
     * This method gets and returns the correct responses
     *
     * @return int
     */
    public int getCorrectResponse() {
        return correctResponse;
    }

    /**
     * This method gets and returns the incorrect responses
     *
     * @return int
     */
    public int getIncorrectResponse() {
        return incorrectResponse;
    }

    /**
     * This method exits the application with a goodbye toast
     */
    private void exitApp() {

        //account for missed questions in final score
        int j = 0;
        int k = 0;

        j = getCorrectResponse() + getIncorrectResponse();
        if (4 - j != 0) {
            k = 4 - j;
        }
        finalScoreCount = (getCorrectResponse() + "/" + (getIncorrectResponse() + k));

        Toast toast = Toast.makeText(getApplicationContext(), "Your final score is " + finalScoreCount + ". Goodbye.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        TextView v = toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.WHITE);
        v.setBackgroundColor(Color.TRANSPARENT);
        toast.show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        }, 4000);
    }


}
