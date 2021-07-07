package com.example.profilemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etEmail, etNOHP, etAlamat;
    Button btnprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etNOHP = findViewById(R.id.etNoHP);
        etAlamat = findViewById(R.id.etAlamat);

        btnprofile = findViewById(R.id.btnprofile);
        btnprofile.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.btnprofile:
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            break;
    }
    }
}