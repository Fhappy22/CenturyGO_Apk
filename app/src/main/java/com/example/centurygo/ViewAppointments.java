package com.example.centurygo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewAppointments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointments);


        String date = getIntent().getStringExtra("DATE");
        String time = getIntent().getStringExtra("TIME");
        String description = getIntent().getStringExtra("DESCRIPTION");


        TextView textViewDate = findViewById(R.id.textViewDate);
        TextView textViewTime = findViewById(R.id.textViewTime);
        TextView textViewDescription = findViewById(R.id.textViewDescription);

        textViewDate.setText(date);
        textViewTime.setText(time);
        textViewDescription.setText(description);


        Button btnBackToSchedule = findViewById(R.id.btnBackToSchedule);
        btnBackToSchedule.setOnClickListener(v -> {
            Intent intent = new Intent(ViewAppointments.this, ScheduleAppointment.class);
            startActivity(intent);
        });
    }
}
