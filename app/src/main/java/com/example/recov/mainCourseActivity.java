package com.example.recov;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mainCourseActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_course);

        button1 = (Button) findViewById(R.id.pastaButton);
        button2 = (Button) findViewById(R.id.riceButton);
        button3 = (Button) findViewById(R.id.pizzaButton);
        button4 = (Button) findViewById(R.id.eggButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(mainCourseActivity.this,pastaActivity.class);
                startActivity(a);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(mainCourseActivity.this, riceActivity.class);
                startActivity(b);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(mainCourseActivity.this, pizzaActivity.class);
                startActivity(c);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(mainCourseActivity.this, omeletteActivity.class);
                startActivity(d);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_logout:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
    }
}
