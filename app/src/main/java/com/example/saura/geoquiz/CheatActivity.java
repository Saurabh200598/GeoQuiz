package com.example.saura.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by saura on 7/2/2018.
 */

public class CheatActivity extends Activity {
    public static final String EXTRA_ANSWER_SHOWN =
            "com.saura.android.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private static final String CHECK ="Result";
    private String s1 = "";


    private void updateQuestion1() {
        //mQuestionTextView.setText(question);

        mAnswerTextView.setText(s1);
        setAnswerShownResult(true);
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        setAnswerShownResult(false);

        mAnswerIsTrue = getIntent().getBooleanExtra("k1",false);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mAnswerTextView =(TextView)findViewById(R.id.answerTextView);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mAnswerIsTrue)
                {
                    mAnswerTextView.setText(R.string.true_button);
                }
                else
                    mAnswerTextView.setText(R.string.false_button);
                setAnswerShownResult(true);
            }

        });

        if(savedInstanceState!=null)
        {

            s1 = savedInstanceState.getString(CHECK);
        }
        updateQuestion1();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(CHECK,mAnswerTextView.getText().toString());
    }


}
