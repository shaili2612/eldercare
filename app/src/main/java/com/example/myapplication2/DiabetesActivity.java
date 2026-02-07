package com.example.myapplication2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DiabetesActivity extends AppCompatActivity {

    EditText etSugar;
    Button btnAddSugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diabetics);

        etSugar = findViewById(R.id.etSugar);
        btnAddSugar = findViewById(R.id.btnAddSugar);

        btnAddSugar.setOnClickListener(v -> {
            String sugar = etSugar.getText().toString();
            if(sugar.isEmpty()){
                Toast.makeText(this, "Enter sugar value", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Blood sugar recorded: " + sugar, Toast.LENGTH_SHORT).show();
        });
    }
}
