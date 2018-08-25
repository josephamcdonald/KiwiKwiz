package com.example.android.kiwikwiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;

/**
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 3
 * Version: 2.0
 * App Name: Quizzy - the Kiwi Kwiz
 * Author: Joseph McDonald
 */

public class CapitalCityActivity extends AppCompatActivity {

    // Declare and initialize boolean used for scoring this activity.
    static boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_city);

        // Declare and find all the radio buttons.
        final RadioButton radioAuckland = findViewById(R.id.radio_auckland);
        final RadioButton radioHamilton = findViewById(R.id.radio_hamilton);
        final RadioButton radioChristchurch = findViewById(R.id.radio_christchurch);
        final RadioButton radioWellington = findViewById(R.id.radio_wellington);

        // Set radio button typeface here due to issue. See https://issuetracker.google.com/issues/63250768
        radioAuckland.setTypeface(ResourcesCompat.getFont(this, R.font.fira_sans));
        radioHamilton.setTypeface(ResourcesCompat.getFont(this, R.font.fira_sans));
        radioChristchurch.setTypeface(ResourcesCompat.getFont(this, R.font.fira_sans));
        radioWellington.setTypeface(ResourcesCompat.getFont(this, R.font.fira_sans));

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
                // Timer expires, stop progress bar, mark incorrect, Toast time expired and go to next question.
                myProgressBar.setProgress(100);
                correct = false;
                QuizzyEngine.toastIt(CapitalCityActivity.this, getText(R.string.toast_time_expired));
                QuizzyEngine.advanceToNext(CapitalCityActivity.this, QuizzyEngine.question[++QuizzyEngine.questionCount]);
            }
        }.start();

        // Find NEXT button.
        final Button buttonNext = findViewById(R.id.button_bottom);

        // Create myOnClickListener for NEXT button.
        OnClickListener myOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                // If any radio button checked, question is attempted.
                final boolean questionAttempted =
                        radioAuckland.isChecked() ||
                        radioHamilton.isChecked() ||
                        radioChristchurch.isChecked() ||
                        radioWellington.isChecked();

                // The correct attempt is Wellington.
                correct = radioWellington.isChecked();

                // If question is attempted, stop the timer, process attempt for correctness and go to next question.
                // else show a Toast to encourage an attempt.
                if (questionAttempted) {
                    myCountDownTimer.cancel();
                    QuizzyEngine.processAttempt(CapitalCityActivity.this, correct);
                    QuizzyEngine.advanceToNext(CapitalCityActivity.this, QuizzyEngine.question[++QuizzyEngine.questionCount]);

                } else {
                    QuizzyEngine.toastIt(CapitalCityActivity.this, getText(R.string.toast_please_attempt));
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
