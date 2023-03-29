package com.example.recov;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class desertActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desert_course);

        button1 = (Button) findViewById(R.id.cheesecakeButton);
        button2 = (Button) findViewById(R.id.madeleinesButton);
        button3 = (Button) findViewById(R.id.brownieButton);
        button4 = (Button) findViewById(R.id.muffinsButton);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(desertActivity.this,cheesecakeActivity.class);
                startActivity(a);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(desertActivity.this,madeleinesActivity.class);
                startActivity(b);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(desertActivity.this,browniesActivity.class);
                startActivity(c);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(desertActivity.this,muffinsActivity.class);
                startActivity(d);
            }
        });
    }
}
