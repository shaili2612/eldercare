package com.example.myapplication2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentsActivity extends AppCompatActivity {

    EditText etDocName, etReason, etDateTime;
    Button btnAddAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointments);

        etDocName = findViewById(R.id.etDocName);
        etReason = findViewById(R.id.etReason);
        etDateTime = findViewById(R.id.etDateTime);
        btnAddAppointment = findViewById(R.id.btnAddAppointment);

        btnAddAppointment.setOnClickListener(v -> {
            String name = etDocName.getText().toString();
            String reason = etReason.getText().toString();
            String dateTime = etDateTime.getText().toString();

            if(name.isEmpty() || reason.isEmpty() || dateTime.isEmpty()){
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Appointment saved!", Toast.LENGTH_SHORT).show();
            // Later: set reminders using AlarmManager
        });
    }
}
