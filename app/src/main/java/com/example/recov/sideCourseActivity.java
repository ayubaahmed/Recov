package com.example.recov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sideCourseActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.side_course);

        button1 = (Button) findViewById(R.id.toastButton);
        button2 = (Button) findViewById(R.id.pancakeButton);
        button3 = (Button) findViewById(R.id.fruitSaladButton);
        button4 = (Button) findViewById(R.id.mashedPotatoesButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(sideCourseActivity.this, frenchToastActivity.class);
                startActivity(a);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(sideCourseActivity.this,pancakeActivity.class);
                startActivity(b);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(sideCourseActivity.this,saladActivity.class);
                startActivity(c);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(sideCourseActivity.this,mashedPotatoesActivity.class);
                startActivity(d);
            }
        });

    }
}
