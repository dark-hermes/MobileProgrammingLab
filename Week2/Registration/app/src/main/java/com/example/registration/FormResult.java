package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FormResult extends AppCompatActivity {

    TextView etNameResult, etNimResult, etSiblingsResult, etAllowanceResult, etGenderResult;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_result);

        etNameResult = findViewById(R.id.et_name_result);
        etNimResult = findViewById(R.id.et_nim_result);
        etSiblingsResult = findViewById(R.id.et_siblings_result);
        etAllowanceResult = findViewById(R.id.et_allowance_result);
        etGenderResult = findViewById(R.id.et_gender_result);
        btnHome = findViewById(R.id.btn_home);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String nim = intent.getStringExtra("nim");
        String siblings = intent.getStringExtra("siblings");
        String allowance = intent.getStringExtra("allowance");
        String gender = intent.getStringExtra("gender");

        etNameResult.setText(name);
        etNimResult.setText(nim);
        etSiblingsResult.setText(siblings);
        etAllowanceResult.setText(allowance);
        etGenderResult.setText(gender);

        if ("M".equals(gender)) {
            etGenderResult.setText("Laki-laki");
        } else if ("F".equals(gender)) {
            etGenderResult.setText("Perempuan");
        } else {
            etGenderResult.setText("Tidak Diketahui");
        }

        btnHome.setOnClickListener(v -> {
            Intent homeIntent = new Intent(FormResult.this, RegistrationForm.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeIntent);
            finish(); // Optional: to finish this activity and remove it from the back stack
        });
    }

}
