package com.example.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        int a = getIntent().getIntExtra("Result", 0);
        int b = getIntent().getIntExtra("Questions", 0);
        TextView textView = findViewById(R.id.textView4);
        textView.setText(a + " "+"из"+ " "+ b);

    }
}
