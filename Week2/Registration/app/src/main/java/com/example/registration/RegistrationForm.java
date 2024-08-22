package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationForm extends AppCompatActivity {


    EditText etName, etNim, etSiblings, etAllowance;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.et_name);
        etNim = findViewById(R.id.et_nim);
        etSiblings = findViewById(R.id.et_siblings);
        etAllowance = findViewById(R.id.et_allowance);
        rgGender = findViewById(R.id.rg_gender);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String nim = etNim.getText().toString();
            String siblings = etSiblings.getText().toString();
            String allowance = etAllowance.getText().toString();
            Character gender = rbMale.isChecked() ? 'M' : 'F';

            if (name.isEmpty()) {
                etName.setError("Nama tidak boleh kosong");
                etName.requestFocus();
            } else if (nim.isEmpty()) {
                etNim.setError("NIM tidak boleh kosong");
                etNim.requestFocus();
            } else if (siblings.isEmpty()) {
                etSiblings.setError("Jumlah saudara wajib diisi!");
                etSiblings.requestFocus();
            } else if (allowance.isEmpty()) {
                etAllowance.setError("Jumlah uang per bulan wajib diisi!");
                etAllowance.requestFocus();
            } else {
                Intent intent = new Intent(RegistrationForm.this, TermConditions.class);
                startActivity(intent);
            }
        });

    }
}