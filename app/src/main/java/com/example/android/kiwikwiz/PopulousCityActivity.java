package com.example.android.kiwikwiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

/**
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 3
 * Version: 2.0
 * App Name: Quizzy - the Kiwi Kwiz
 * Author: Joseph McDonald
 */

public class PopulousCityActivity extends AppCompatActivity {

    // Declare and initialize boolean used for scoring this activity.
    static boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populous_city);

        // Declare Strings of acceptable text entries for this question.
        final String acceptableAuckland = getString(R.string.answer_nz_populous_auckland);

        // Declare and find the text entry view.
        final EditText attemptHere = findViewById(R.id.attempt_here);

        // Declare, find and set ProgressBar.
        final ProgressBar myProgressBar = findViewById(R.id.progressbar);

        // Declare, initialize and start CountDownTimer.
        final CountDownTimer myCountDownTimer = new CountDownTimer(QuizzyEngine.QUIZZY_TIMER_IN_SECONDS * 1000, 1000) {

            // Declare and initialize progressbar variable.
            private int barProgress = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                myProgressBar.setProgress(++barProgress * 100 / QuizzyEngine.QUIZZY_TIMER_IN_SECONDS);
            }

            @Override
            public void onFinish() {
                // Stop progress bar, mark incorrect, Toast time expired and go to next question.
                myProgressBar.setProgress(100);
                correct = false;
                QuizzyEngine.toastIt(PopulousCityActivity.this, getText(R.string.toast_time_expired));
                QuizzyEngine.advanceToNext(PopulousCityActivity.this, QuizzyEngine.question[++QuizzyEngine.questionCount]);
            }
        }.start();

        // Find NEXT button.
        final Button buttonNext = findViewById(R.id.button_bottom);

        // Create myOnClickListener for NEXT button.
        OnClickListener myOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Convert string entered to all lowercase.
                final String stringAttempted = attemptHere.getText().toString().toLowerCase();

                // When string entered is NOT empty the question is attempted.
                final boolean questionAttempted = !stringAttempted.isEmpty();

                // The correct string contains "auckland".
                correct = stringAttempted.contains(acceptableAuckland);

                // If question is attempted, stop the timer, process attempt for correctness and go to next question.
                // else show a Toast to encourage an attempt.
                if (questionAttempted) {
                    myCountDownTimer.cancel();
                    QuizzyEngine.processAttempt(PopulousCityActivity.this, correct);
                    QuizzyEngine.advanceToNext(PopulousCityActivity.this, QuizzyEngine.question[++QuizzyEngine.questionCount]);

                } else {
                    QuizzyEngine.toastIt(PopulousCityActivity.this, getText(R.string.toast_please_attempt));
                }
            }
        };
        // Set myOnClickListener to NEXT button.
        buttonNext.setOnClickListener(myOnClickListener);
    }

    /**
     * During this activity, toast an encouraging message to continue the activity.
     */
    @Override
    public void onBackPressed() {
        QuizzyEngine.toastIt(this, getText(R.string.toast_backbutton_disabled));
    }
}
