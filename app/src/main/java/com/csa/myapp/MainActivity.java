package com.example.billblender;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button remixBtn = findViewById(R.id.remix_button);
        remixBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RemixActivity.class));
        });

        Button battleBtn = findViewById(R.id.battle_button);
        battleBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, BattleActivity.class));
        });
    }
}