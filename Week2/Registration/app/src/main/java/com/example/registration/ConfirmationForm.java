package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import android.widget.TextView;

public class ConfirmationForm extends AppCompatActivity {

    TextView tvName, tvNim, tvSiblings, tvAllowance, tvGender;
    Button btnEdit, btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_form);

        tvName = findViewById(R.id.tv_name);
        tvNim = findViewById(R.id.tv_nim);
        tvSiblings = findViewById(R.id.tv_siblings);
        tvAllowance = findViewById(R.id.tv_allowance);
        tvGender = findViewById(R.id.tv_gender);
        btnEdit = findViewById(R.id.btn_edit);
        btnProceed = findViewById(R.id.btn_proceed);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String nim = intent.getStringExtra("nim");
        String siblings = intent.getStringExtra("siblings");
        String allowance = intent.getStringExtra("allowance");
        String gender = intent.getStringExtra("gender");

        tvName.setText(name);
        tvNim.setText(nim);
        tvSiblings.setText(siblings);
        tvAllowance.setText(allowance);
        tvGender.setText(gender.equals("M") ? "Laki-laki" : "Perempuan");
        btnEdit.setOnClickListener(v -> {
            finish();
        });

        btnProceed.setOnClickListener(v -> {
            Intent proceedIntent = new Intent(ConfirmationForm.this, TermConditions.class);
            proceedIntent.putExtra("name", name);
            proceedIntent.putExtra("nim", nim);
            proceedIntent.putExtra("siblings", siblings);
            proceedIntent.putExtra("allowance", allowance);
            proceedIntent.putExtra("gender", gender);
            startActivity(proceedIntent);
        });
    }


}