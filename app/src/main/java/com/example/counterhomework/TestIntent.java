package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class TestIntent extends AppCompatActivity {

    EditText inpTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intent);

        Intent intent = getIntent();
        String getIntentExValue = intent.getStringExtra("joss");
        inpTest = findViewById(R.id.inp_test);
        inpTest.setText(getIntentExValue);
    }
}