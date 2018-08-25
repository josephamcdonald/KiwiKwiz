package com.example.android.kiwikwiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 3
 * Version: 2.0
 * App Name: Quizzy - the Kiwi Kwiz
 * Author: Joseph McDonald
 */

public class QuizzyEngine extends AppCompatActivity {

    // Declare static variables used for scoring and the timer.
    static int scoreQuiz;
    static int questionCount;
    static final int QUIZZY_TIMER_IN_SECONDS = 20;

    // The order of questions in an array of Classes.
    final static Class question[] = {

            // The order of questions starts here.
            KiwiActivity.class,
            PopulousCityActivity.class,
            HakaActivity.class,
            CapitalCityActivity.class,
            CricketActivity.class,
            FlagActivity.class,
            SuffrageActivity.class,

            // The Summary Activity is last.
            SummaryActivity.class};

    /**
     * If attempt is correct, increment quiz score and toast attempt is correct.
     * else toast attempt is incorrect.
     *
     * @param attemptContext - the context of the question attempt.
     * @param attemptIsCorrect - the attempt is correct (true) or incorrect (false).
     **/
    static void processAttempt(Context attemptContext, boolean attemptIsCorrect) {
        if (attemptIsCorrect) {
            ++scoreQuiz;
            toastIt(attemptContext, attemptContext.getText(R.string.toast_correct));

        } else {
            toastIt(attemptContext, attemptContext.getText(R.string.toast_incorrect));
        }
    }

    /**
     * Toast a message from a passed Context.
     *
     * @param toastContext - the context of the toast.
     * @param messageToToast - the message to toast.
     **/
    static void toastIt(Context toastContext, CharSequence messageToToast) {
        Toast toast = Toast.makeText(toastContext, messageToToast, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 250);
        toast.show();
    }

    /**
     * Advance to the next activity.
     *
     * @param activityContext - the context of the current activity.
     * @param nextActivity - the next activity.
     */
    static void advanceToNext(Context activityContext, Class nextActivity) {
        Intent intentNext = new Intent(activityContext, nextActivity);
        activityContext.startActivity(intentNext);
    }
}
