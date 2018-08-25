package com.example.android.kiwikwiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 3
 * Version: 2.0
 * App Name: Quizzy - the Kiwi Kwiz
 * Author: Joseph McDonald
 */

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Declare and find the views and buttons.
        final TextView bannerSummary = findViewById(R.id.banner_summary);
        final ImageView imageSummary = findViewById(R.id.image_summary);
        final View answersSummary = findViewById(R.id.answers_summary);
        final Button buttonShare = findViewById(R.id.button_share);
        final Button buttonBottom = findViewById(R.id.button_bottom);

        // Declare and find views to change text color to green or red based on attempt correctness.
        final TextView answerSummaryKiwi = findViewById(R.id.answer_summary_kiwi);
        final TextView answerSummaryPopulous = findViewById(R.id.answer_summary_populous);
        final TextView answerSummaryHaka = findViewById(R.id.answer_summary_haka);
        final TextView answerSummaryCapital = findViewById(R.id.answer_summary_capital);
        final TextView answerSummaryCricket = findViewById(R.id.answer_summary_cricket);
        final TextView answerSummaryFlag = findViewById(R.id.answer_summary_flag);
        final TextView answerSummarySuffrage = findViewById(R.id.answer_summary_suffrage);

        // Generate initial summary string with some green (correct) and red (incorrect) text.
        final String correctGreen = getString(R.string.font_green);
        final String incorrectRed = getString(R.string.font_red);
        final String stringBannerSummary = getString(R.string.banner_summary_well_done)
                + correctGreen + getString(R.string.banner_summary_and)
                + incorrectRed + getString(R.string.banner_summary_answers);

        // Display initial banner summary.
        bannerSummary.setText(Html.fromHtml(stringBannerSummary));

        // Generate quiz result summary string to be displayed in the banner.
        final String resultQuizSummary = getString(R.string.send_result_you_got) + String.valueOf(QuizzyEngine.scoreQuiz)
                + getString(R.string.send_result_correct) + String.valueOf(QuizzyEngine.questionCount) +
                getString(R.string.send_result_on_the_quiz) + getText(R.string.banner_summary_share);

        // Generate quiz result toast message.
        final CharSequence resultToast = getText(R.string.toast_result) + String.valueOf(QuizzyEngine.scoreQuiz) +
                getText(R.string.send_result_correct) + String.valueOf(QuizzyEngine.questionCount);

        // If KiwiActivity question attempted correctly, change answer text color to green.
        // else change answer text color to red.
        if (KiwiActivity.correct) {
            answerSummaryKiwi.setTextColor(getResources().getColor(R.color.colorCorrect));

        } else {
            answerSummaryKiwi.setTextColor(getResources().getColor(R.color.colorIncorrect));
        }

        // If PopulousCityActivity question attempted correctly, change answer text color to green.
        // else change answer text color to red.
        if (PopulousCityActivity.correct) {
            answerSummaryPopulous.setTextColor(getResources().getColor(R.color.colorCorrect));

        } else {
            answerSummaryPopulous.setTextColor(getResources().getColor(R.color.colorIncorrect));
        }

        // If HakaActivity question attempted correctly, change answer text color to green.
        // else change answer text color to red.
        if (HakaActivity.correct) {
            answerSummaryHaka.setTextColor(getResources().getColor(R.color.colorCorrect));

        } else {
            answerSummaryHaka.setTextColor(getResources().getColor(R.color.colorIncorrect));
        }

        // If CapitalCityActivity question attempted correctly, change answer text color to green.
        // else change answer text color to red.
        if (CapitalCityActivity.correct) {
            answerSummaryCapital.setTextColor(getResources().getColor(R.color.colorCorrect));

        } else {
            answerSummaryCapital.setTextColor(getResources().getColor(R.color.colorIncorrect));
        }

        // If CricketActivity question attempted correctly, change answer text color to green.
        // else change answer text color to red.
        if (CricketActivity.correct) {
            answerSummaryCricket.setTextColor(getResources().getColor(R.color.colorCorrect));

        } else {
            answerSummaryCricket.setTextColor(getResources().getColor(R.color.colorIncorrect));
        }

        // If FlagActivity question attempted correctly, change answer text color to green.
        // else change answer text color to red.
        if (FlagActivity.correct) {
            answerSummaryFlag.setTextColor(getResources().getColor(R.color.colorCorrect));

        } else {
            answerSummaryFlag.setTextColor(getResources().getColor(R.color.colorIncorrect));
        }

        // If SuffrageActivity question attempted correctly, change answer text color to green.
        // else change answer text color to red.
        if (SuffrageActivity.correct) {
            answerSummarySuffrage.setTextColor(getResources().getColor(R.color.colorCorrect));

        } else {
            answerSummarySuffrage.setTextColor(getResources().getColor(R.color.colorIncorrect));
        }

        // Create myOnClickListener for GET MY GRADE button.
        OnClickListener myOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Make the initial summary image disappear.
                imageSummary.setVisibility(View.GONE);

                // Display quiz result message in the banner.
                bannerSummary.setText(resultQuizSummary);

                // Show the share button.
                buttonShare.setVisibility(View.VISIBLE);

                // Show the correct answers in a scrollable view.
                answersSummary.setVisibility(View.VISIBLE);

                // Setup bottom button as RESTART.
                buttonBottom.setText(R.string.button_restart);

                //Toast quiz result message.
                QuizzyEngine.toastIt(SummaryActivity.this, resultToast);

                // Create myOnClickListener for RESTART button and share button.
                OnClickListener myOnClickListener = new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.button_share:
                                // Generate the share message.
                                final String stringShareResult = getString(R.string.send_result_i_got)
                                        + String.valueOf(QuizzyEngine.scoreQuiz)
                                        + getString(R.string.send_result_correct)
                                        + String.valueOf(QuizzyEngine.questionCount)
                                        + getString(R.string.send_result_on_the_quiz);

                                // Create ACTION_SEND Intent and start it.
                                Intent shareIntent = new Intent();
                                shareIntent.setAction(Intent.ACTION_SEND);
                                shareIntent.putExtra(Intent.EXTRA_TEXT, stringShareResult);
                                shareIntent.setType(getString(R.string.text_plain));
                                startActivity(shareIntent);
                                break;

                            case R.id.button_bottom:
                                // Go to the Main activity.
                                Intent intentNext = new Intent(SummaryActivity.this, MainActivity.class);
                                startActivity(intentNext);
                                break;
                        }
                    }
                };
                // Set myOnClickListener to share and RESTART buttons.
                buttonShare.setOnClickListener(myOnClickListener);
                buttonBottom.setOnClickListener(myOnClickListener);
            }
        };
        // Set myOnClickListener to GET MY GRADE button.
        buttonBottom.setOnClickListener(myOnClickListener);
    }

    @Override
    public void onBackPressed() {
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exitIntent);
    }
}
