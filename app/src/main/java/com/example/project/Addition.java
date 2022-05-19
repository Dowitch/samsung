package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Addition extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);
        Button nextEasy = (Button) findViewById(R.id.NextEasy);
        Button nextHard = (Button) findViewById(R.id.NextHard);
        Button nextMedium = (Button) findViewById(R.id.NextMedium);
        Button nextNormal = (Button) findViewById(R.id.NextNormal);


        nextEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Addition.this, Addition_easy.class);
                startActivity(intent);
            }
        });
        nextNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Addition.this, Addition_normal.class);
                startActivity(intent);
            }
        });
        nextMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Addition.this, Addition_medium.class);
                startActivity(intent);
            }
        });
        nextHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Addition.this, Addition_hard.class);
                startActivity(intent);
            }
        });
    }
}

