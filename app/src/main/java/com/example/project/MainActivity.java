package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button Multiply = (Button)findViewById(R.id.Multiply);
        Button Addition = (Button)findViewById(R.id.Addition);
        Button Subtract = (Button)findViewById(R.id.Subtract);
        Button Division = (Button)findViewById(R.id.Division);



        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Multiplication.class);
                startActivity(intent);
            }
        });
        Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Addition.class);
                startActivity(intent);
            }
        });  Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Subtract.class);
                startActivity(intent);
            }
        });  Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Division.class);
                startActivity(intent);
            }
        });

        }

    }
