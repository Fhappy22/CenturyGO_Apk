package com.example.centurygo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Botón para agendar cita
        Button buttonA = findViewById(R.id.buttonA);
        buttonA.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, ScheduleAppointment.class);
            startActivity(intent);
        });

        // Botón para ver citas
        Button buttonV = findViewById(R.id.buttonV);
        buttonV.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, ViewAppointments.class);
            startActivity(intent);
        });

        // Botón para historial de citas
        Button buttonH = findViewById(R.id.buttonH);
        buttonH.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, Us.class);
            startActivity(intent);
        });

        // Botón para regresar (Atrás)
        Button buttonB = findViewById(R.id.buttonB);
        buttonB.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, LoginActivity.class);
            startActivity(intent);
        });

        // Botón para continuar
        Button buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, ScheduleAppointment.class);
            startActivity(intent);
        });

        // Botón de configuración
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, Settings.class);
            startActivity(intent);
        });
    }
}
