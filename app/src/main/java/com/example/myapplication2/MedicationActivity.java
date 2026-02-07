package com.example.myapplication2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MedicationActivity extends AppCompatActivity {

    EditText etMedName, etTime;
    Button btnAddMed;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medication);

        etMedName = findViewById(R.id.etMedName);
        etTime = findViewById(R.id.etMedTime);
        btnAddMed = findViewById(R.id.btnAddMed);

        tts = new TextToSpeech(this, status -> {
            if(status != TextToSpeech.ERROR){
                tts.setLanguage(Locale.US);
            }
        });

        btnAddMed.setOnClickListener(v -> {
            String medName = etMedName.getText().toString();
            String time = etTime.getText().toString();

            if(medName.isEmpty() || time.isEmpty()){
                Toast.makeText(this, "Enter both name and time", Toast.LENGTH_SHORT).show();
                return;
            }

            // Speak reminder immediately (just demo)
            tts.speak("Medication " + medName + " is scheduled at " + time, TextToSpeech.QUEUE_FLUSH, null, null);
            Toast.makeText(this, "Medication added!", Toast.LENGTH_SHORT).show();

            // Later: schedule AlarmManager for actual time
        });
    }

    @Override
    public void onDestroy() {
        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
