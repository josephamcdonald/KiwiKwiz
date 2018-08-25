package com.example.android.kiwikwiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;

/**
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 3
 * Version: 2.0
 * App Name: Quizzy - the Kiwi Kwiz
 * Author: Joseph McDonald
 */

public class HakaActivity extends AppCompatActivity {

    // Declare and initialize boolean used for scoring this activity.
    static boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haka);

        // Declare and find all the checkboxes.
        final CheckBox checkBoxFood = findViewById(R.id.checkBox_nz_delicacy);
        final CheckBox checkBoxDance = findViewById(R.id.checkBox_dance);
        final CheckBox checkBoxMusic = findViewById(R.id.checkBox_nz_music);
        final CheckBox checkBoxRugby = findViewById(R.id.checkBox_rugby);

        // Set checkbox typeface here due to issue. See https://issuetracker.google.com/issues/63250768
        checkBoxFood.setTypeface(ResourcesCompat.getFont(this, R.font.fira_sans));
        checkBoxDance.setTypeface(ResourcesCompat.getFont(this, R.font.fira_sans));
        checkBoxMusic.setTypeface(ResourcesCompat.getFont(this, R.font.fira_sans));
        checkBoxRugby.setTypeface(ResourcesCompat.getFont(this, R.font.fira_sans));

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
                QuizzyEngine.toastIt(HakaActivity.this, getText(R.string.toast_time_expired));
                QuizzyEngine.advanceToNext(HakaActivity.this, QuizzyEngine.question[++QuizzyEngine.questionCount]);
            }
        }.start();

        // Find NEXT button.
        final Button buttonNext = findViewById(R.id.button_bottom);

        // Create myOnClickListener for NEXT button.
        OnClickListener myOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                // If any checkBox is checked, question is attempted.
                final boolean questionAttempted =
                        checkBoxFood.isChecked() ||
                        checkBoxDance.isChecked() ||
                        checkBoxMusic.isChecked() ||
                        checkBoxRugby.isChecked();

                // The attempt is correct only when checkBoxDance and checkBoxRugby is checked.
                correct = !checkBoxFood.isChecked() &&
                        checkBoxDance.isChecked() &&
                        !checkBoxMusic.isChecked() &&
                        checkBoxRugby.isChecked();

                // If question is attempted, stop the timer, process attempt for correctness and go to next question.
                // else show a Toast to encourage an attempt.
                if (questionAttempted) {
                    myCountDownTimer.cancel();
                    QuizzyEngine.processAttempt(HakaActivity.this, correct);
                    QuizzyEngine.advanceToNext(HakaActivity.this, QuizzyEngine.question[++QuizzyEngine.questionCount]);

                } else {
                    QuizzyEngine.toastIt(HakaActivity.this, getText(R.string.toast_please_attempt));
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