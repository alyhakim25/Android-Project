package com.example.foodrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView Menu1, Menu2, Menu3, Menu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Menu1 = (CardView) findViewById(R.id.CardView_Menu1);
        Menu2 = (CardView) findViewById(R.id.CardView_Menu2);
        Menu3 = (CardView) findViewById(R.id.CardView_Menu3);
        Menu4 = (CardView) findViewById(R.id.CardView_Menu4);

        Menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoTo = new Intent(MainActivity.this, RecipeActivity.class);
                GoTo.putExtra("Menu", "Menu1");
                startActivity(GoTo);
            }
        });
        Menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoTo = new Intent(MainActivity.this, RecipeActivity.class);
                GoTo.putExtra("Menu", "Menu2");
                startActivity(GoTo);
            }
        });
        Menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoTo = new Intent(MainActivity.this, RecipeActivity.class);
                GoTo.putExtra("Menu", "Menu3");
                startActivity(GoTo);
            }
        });
        Menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoTo = new Intent(MainActivity.this, RecipeActivity.class);
                GoTo.putExtra("Menu", "Menu4");
                startActivity(GoTo);
            }
        });
    }
}