package com.example.android.kiwikwiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 3
 * Version: 2.0
 * App Name: Quizzy - the Kiwi Kwiz
 * Author: Joseph McDonald
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the overall score and question count static variables within the QuizzyEngine.
        QuizzyEngine.scoreQuiz = 0;
        QuizzyEngine.questionCount = 0;

        // Find START button.
        final Button buttonStart = findViewById(R.id.button_bottom);

        // Create myOnClickListener for START button.
        OnClickListener myOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Advance to first question when START button clicked.
                QuizzyEngine.advanceToNext(MainActivity.this, QuizzyEngine.question[QuizzyEngine.questionCount]);
            }
        };
        // Set myOnClickListener to START button.
        buttonStart.setOnClickListener(myOnClickListener);
    }

    @Override
    public void onBackPressed() {
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exitIntent);
    }
}