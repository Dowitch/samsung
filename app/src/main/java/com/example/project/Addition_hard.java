package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Random;

public class Addition_hard extends Activity {
    ProgressBar mProgressBar;
    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    TextView mScoreTextView;
    int mScore;
    int mPoints;
    final int questions_number = 10;


    String x;
    ArrayList<Integer> values = new ArrayList<>();

    int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / questions_number);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_Button);
        mQuestionTextView = findViewById(R.id.question);
        mScoreTextView = findViewById(R.id.marks);
        mProgressBar = findViewById(R.id.prograssbar);
        updateQuestion();


        if (savedInstanceState != null) {
            Log.d("state", "New State");
            mScore = savedInstanceState.getInt("ScoreKey");
        }else {
            mScore = 0;
            mPoints = 0;

        }
        mScoreTextView.setText("ะกััั:" + mScore + "/" + questions_number);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswerTrue();
                updateQuestion();

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkAnswerFalse();
                updateQuestion();
            }
        });

    }

    private void checkAnswerTrue() {
        int a = values.get(0);
        int b = values.get(1);
        int c = values.get(2);
        boolean correct = a + b < c;
        if (correct == true) {

            AlertDialog.Builder Success = new AlertDialog.Builder(Addition_hard.this);
            Success.setTitle("ะะฐั ะพัะฒะตั ะัะฐะฒะธะปัะฝัะน ");
            Success.show();
            mScore++;
            mPoints++;
        } else {
            AlertDialog.Builder Failure = new AlertDialog.Builder(Addition_hard.this);
            Failure.setTitle("ะะฐั ะพัะฒะตั ะะตะฟัะฐะฒะธะปัะฝัะน ");
            Failure.show();
            mPoints++;

        }
    }
    private void checkAnswerFalse() {
        int a = values.get(0);
        int b = values.get(1);
        int c = values.get(2);
        boolean correct = a + b < c;
        if (correct == false) {

            AlertDialog.Builder Success = new AlertDialog.Builder(Addition_hard.this);
            Success.setTitle("ะะฐั ะพัะฒะตั ะัะฐะฒะธะปัะฝัะน ");
            Success.show();
            mScore++;
            mPoints++;
        } else{
            AlertDialog.Builder Success = new AlertDialog.Builder(Addition_hard.this);
            Success.setTitle("ะะฐั ะพัะฒะตั ะะตัะฐะฒะธะปัะฝัะน ");
            Success.show();
            mPoints++;

        }
    }


    void updateQuestion(){
        if (mPoints == questions_number) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setCancelable(false);
            alert.setMessage("ะะฐั ัััั " + mScore + "/" + questions_number);
            alert.show();
            Intent intent = new Intent(Addition_hard.this, ResultActivity.class);
            intent.putExtra("Result", mScore);
            intent.putExtra("Questions", questions_number);
            startActivity(intent);
        }
        values = questions_generation();
        int a = values.get(0);
        int b = values.get(1);
        int c = values.get(2);

        x = a + "+" + b + "<" + c;


        mQuestionTextView.setText(x);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mScoreTextView.setText("ะกััั:" + mScore + "/" + questions_number);
    }
    public ArrayList<Integer> questions_generation(){
        ArrayList<Integer> values = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            values.add((int) (Math.random()*200 + 100));
        }
        ArrayList<Integer> qwerty = new ArrayList<>();
        int a = values.get(1);
        int b = values.get(2);
        int c = (int) Math.round(Math.random() * 400 + 150);
        qwerty.add(a);
        qwerty.add(b);
        qwerty.add(c);
        return qwerty;
    }

}




