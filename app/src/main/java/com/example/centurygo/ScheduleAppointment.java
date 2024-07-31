package com.example.centurygo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Calendar;

public class ScheduleAppointment extends AppCompatActivity {

    private EditText editTextDate, editTextTime, editTextDescription;
    private Uri fileUri;
    private ActivityResultLauncher<String> filePickerLauncher;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appointment);

        // Initialize UI elements
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextDescription = findViewById(R.id.editTextDescription);
        LinearLayout fileUploadLayout = findViewById(R.id.fileUpload);

        Button btnBack = findViewById(R.id.btnBack);
        Button btnContinue = findViewById(R.id.btnContinue);

        // Initialize the file picker launcher
        filePickerLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), result -> {
            if (result != null) {
                fileUri = result;
                Toast.makeText(ScheduleAppointment.this, "Archivo seleccionado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ScheduleAppointment.this, "No se seleccionó ningún archivo", Toast.LENGTH_SHORT).show();
            }
        });

        // Initialize calendar
        calendar = Calendar.getInstance();

        // Set onClick listeners
        editTextDate.setOnClickListener(v -> showDatePicker());
        editTextTime.setOnClickListener(v -> showTimePicker());
        fileUploadLayout.setOnClickListener(v -> openFilePicker());

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(ScheduleAppointment.this, HomePage.class);
            startActivity(intent);
            finish();
        });

        btnContinue.setOnClickListener(v -> scheduleAppointment());
    }

    private void showDatePicker() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            calendar.set(year1, month1, dayOfMonth);
            String date = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
            editTextDate.setText(date);
        }, year, month, day).show();
    }

    private void showTimePicker() {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        new TimePickerDialog(this, (view, hourOfDay, minute1) -> {
            String time = String.format("%02d:%02d", hourOfDay, minute1);
            editTextTime.setText(time);
        }, hour, minute, true).show();
    }

    private void openFilePicker() {
        filePickerLauncher.launch("application/*");  // Open file
    }

    private void scheduleAppointment() {
        String date = editTextDate.getText().toString().trim();
        String time = editTextTime.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();

        if (date.isEmpty() || time.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (fileUri != null) {

            uploadFile();
        } else {

            Toast.makeText(this, "No se seleccionó ningún archivo", Toast.LENGTH_SHORT).show();
        }


        Intent intent = new Intent(ScheduleAppointment.this, ViewAppointments.class);
        intent.putExtra("DATE", date);
        intent.putExtra("TIME", time);
        intent.putExtra("DESCRIPTION", description);
        startActivity(intent);
    }

    private void uploadFile() {
        if (fileUri == null) {
            Toast.makeText(this, "No se seleccionó ningún archivo para subir", Toast.LENGTH_SHORT).show();
            return;
        }


        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference fileRef = storageRef.child("uploads/" + System.currentTimeMillis() + ".jpg");

        fileRef.putFile(fileUri)
                .addOnSuccessListener(taskSnapshot -> Toast.makeText(ScheduleAppointment.this, "Archivo subido con éxito", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(ScheduleAppointment.this, "Error al subir archivo", Toast.LENGTH_SHORT).show());
    }
}
