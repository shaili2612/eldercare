package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMedication, btnDiabetes, btnAppointments, btnEmergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMedication = findViewById(R.id.btnMedication);
        btnDiabetes = findViewById(R.id.btnDiabetes);
        btnAppointments = findViewById(R.id.btnAppointments);
        btnEmergency = findViewById(R.id.btnEmergency);

        btnMedication.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MedicationActivity.class)));

        btnDiabetes.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DiabetesActivity.class)));

        btnAppointments.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AppointmentsActivity.class)));

        btnEmergency.setOnClickListener(v -> {
            // Simple placeholder for emergency
            Toast.makeText(MainActivity.this, "Emergency Mode Activated!", Toast.LENGTH_LONG).show();
            // Later: add SMS/call functionality
        });
    }
}
