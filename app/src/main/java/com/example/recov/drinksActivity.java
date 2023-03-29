package com.example.recov;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class drinksActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks_course);

        button1 = (Button) findViewById(R.id.cordialButton);
        button2 = (Button) findViewById(R.id.cocktailButton);
        button3 = (Button) findViewById(R.id.milkshakeButton);
        button4 = (Button) findViewById(R.id.coffeeButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(drinksActivity.this, cordialDrinkActivity.class);
                startActivity(a);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(drinksActivity.this, cocktailDrinkActivity.class);
                startActivity(b);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(drinksActivity.this, milkshakeActivity.class);
                startActivity(c);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(drinksActivity.this,coffeeDrinkActivity.class);
                startActivity(d);
            }
        });



    }
}
