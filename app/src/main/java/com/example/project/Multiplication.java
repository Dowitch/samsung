package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Multiplication extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplication);
        Button nextEasy = (Button) findViewById(R.id.NextEasy);

        Button nextHard = (Button) findViewById(R.id.NextHard);
        Button nextMedium = (Button) findViewById(R.id.NextMedium);
        Button nextNormal = (Button) findViewById(R.id.NextNormal);




        nextEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Multiplication.this, Multiplication_easy.class);
                startActivity(intent);
            }
        });
        nextNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Multiplication.this, Multiplication_normal.class);
                startActivity(intent);
            }
        });
        nextMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Multiplication.this, Multiplication_medium.class);
                startActivity(intent);
            }
        });
        nextHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Multiplication.this, Multiplication_hard.class);
                startActivity(intent);
            }
        });

    }
}