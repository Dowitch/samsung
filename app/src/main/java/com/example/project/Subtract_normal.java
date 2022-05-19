package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Subtract_normal extends Activity {
    ProgressBar mProgressBar;
    Button mTrueButton;
    Button mFalseButton;
    Button button1;
    TextView mQuestionTextView;
    TextView mScoreTextView;
    int mScore;
    int mPoints;
    final int questions_number = 10;
    EditText c;
    String x;
    int n;
    ArrayList<Integer> values = new ArrayList<>();

    int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / questions_number);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subtract_main);
        c = (EditText)findViewById(R.id.editText);
        button1 = findViewById(R.id.button);
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
        mScoreTextView.setText("Счёт:" + mScore + "/" + 5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result = checkAnswer();
                if (result){
                    updateQuestion();
                }


            }
        });

    }
    private boolean checkAnswer() {
        int a = values.get(0);
        int b = values.get(1);
        String q = c.getText().toString();
        if (q.equals("")){
            Toast.makeText(getApplicationContext(), "Введите ответ", Toast.LENGTH_LONG).show();
            return false;
        }
        int d = Integer.parseInt(q);

        boolean correct = ((a - b) == d);
        if (correct == true) {

            AlertDialog.Builder Success = new AlertDialog.Builder(Subtract_normal.this);
            Success.setTitle("Ваш ответ Правильный ");
            Success.show();
            mScore++;
            mPoints++;
        } else{
            AlertDialog.Builder Success = new AlertDialog.Builder(Subtract_normal.this);
            Success.setTitle("Ваш ответ Неправильный ");
            Success.show();
            mPoints++;

        }
        c.setText("");
        return true;
    }


    void updateQuestion(){
        if (mPoints == questions_number) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setCancelable(false);
            alert.setMessage("Ваш счёт " + mScore + "/" + questions_number);
            alert.show();
            Intent intent = new Intent(Subtract_normal.this, ResultActivity.class);
            intent.putExtra("Result", mScore);
            intent.putExtra("Questions", questions_number);
            startActivity(intent);
        }
        values = questions_generation();
        int a = values.get(0);
        int b = values.get(1);
        c = (EditText)findViewById(R.id.editText);
        x = a + "-" + b + "=";


        mQuestionTextView.setText(x);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mScoreTextView.setText("Счёт:" + mScore + "/" + questions_number);
    }
    public ArrayList<Integer> questions_generation(){
        ArrayList<Integer> values = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            values.add(rand.nextInt(100) + 1);
        }
        ArrayList<Integer> qwerty = new ArrayList<>();
        int a = values.get(1)+100;
        int b = values.get(2);
        qwerty.add(a);
        qwerty.add(b);
        return qwerty;
    }

}




