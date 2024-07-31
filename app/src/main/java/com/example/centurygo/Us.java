package com.example.centurygo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_us);


        TextView companyName = findViewById(R.id.companyName);
        TextView description = findViewById(R.id.description);
        TextView appVersion = findViewById(R.id.appVersion);
        Button btnBack = findViewById(R.id.btnBack);


        companyName.setText("CenturyLawyers");
        description.setText("En CenturyLawyers, somos abogados comprometidos con la excelencia. Nuestro equipo de profesionales está altamente capacitado para ofrecer asesoría legal de primera calidad, garantizando la mejor representación para nuestros clientes.");
        appVersion.setText("Versión Beta");

        // Back button
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Us.this, HomePage.class);
            startActivity(intent);
            finish();
        });
    }
}
