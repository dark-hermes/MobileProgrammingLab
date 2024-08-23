package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TermConditions extends AppCompatActivity {

    TextView tvTermConditions;
    Button btnCancel, btnRegister;
    CheckBox cbAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_term_conditions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTermConditions = findViewById(R.id.tv_term_conditions);
        btnCancel = findViewById(R.id.btn_cancel);
        btnRegister = findViewById(R.id.btn_register);
        cbAgree = findViewById(R.id.cb_agree);

        tvTermConditions.setText(HtmlCompat.fromHtml(getString(R.string.term_conditions), HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Retrieve data from intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String nim = intent.getStringExtra("nim");
        String siblings = intent.getStringExtra("siblings");
        String allowance = intent.getStringExtra("allowance");
        String gender = intent.getStringExtra("gender");

        btnCancel.setOnClickListener(v -> {
            finish();
        });

        btnRegister.setOnClickListener(v -> {
            if (cbAgree.isChecked()) {
                Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                Intent resultIntent = new Intent(this, FormResult.class);
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("nim", nim);
                resultIntent.putExtra("siblings", siblings);
                resultIntent.putExtra("allowance", allowance);
                resultIntent.putExtra("gender", gender);
                startActivity(resultIntent);
            } else {
                cbAgree.requestFocus();
                Toast.makeText(this, "Centang kotak persetujuan terlebih dahulu!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
