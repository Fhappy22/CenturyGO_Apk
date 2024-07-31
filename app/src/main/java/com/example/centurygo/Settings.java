package com.example.centurygo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        LinearLayout changeTheme = findViewById(R.id.changeTheme);
        LinearLayout legalInfo = findViewById(R.id.legalInfo);
        LinearLayout versionInfo = findViewById(R.id.versionInfo);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnContinue = findViewById(R.id.btnContinue);

        // clicks
        changeTheme.setOnClickListener(v -> {
            // theme
        });

        legalInfo.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, Us.class);
            startActivity(intent);
        });

        versionInfo.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, Us.class);
            startActivity(intent);
        });

        btnBack.setOnClickListener(v -> {
            // Go back to the HomePage activity
            Intent intent = new Intent(Settings.this, HomePage.class);
            startActivity(intent);
            finish(); // Finish
        });

        btnContinue.setOnClickListener(v -> {
            //
        });
    }
}
