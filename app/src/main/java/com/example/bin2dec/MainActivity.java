package com.example.bin2dec;

import android.annotation.SuppressLint;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button convertBinary = findViewById(R.id.convertBinary);
        Button convertDecimal = findViewById(R.id.convertDecimal);
        Button clearButton = findViewById(R.id.reset);
        EditText binaryView = findViewById(R.id.binTextEntry);
        TextView decimalView = findViewById(R.id.decimalText);

        convertBinary.setOnClickListener(view -> {
            String value = binaryView.getText().toString();

            if (value.isEmpty()) {
                binaryView.setError("Enter a valid Binary Number");
            }
            try {
                decimalView.setText(Integer.toString(Integer.parseInt(value, 2)));

            } catch (NumberFormatException n) {
                binaryView.setError("Enter a valid Binary Number");

            }
        });

        convertDecimal.setOnClickListener(view -> {
            String value = decimalView.getText().toString();


            if (value.isEmpty()) {
                decimalView.setError("Enter a valid Integer Number");
            }

            try {
                binaryView.setText(Integer.toBinaryString(Integer.parseInt(value)));

            } catch (Exception e) {
                decimalView.setError("Enter a valid Integer Number");
            }


        });

        clearButton.setOnClickListener(view -> {
            decimalView.setText("");
            binaryView.setText("");
        });

    }
}