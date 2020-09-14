package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText inputText;
    TextView txtCount;
    int angka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("SP", MODE_PRIVATE);
        String input = sharedPreferences.getString("input", "");
        inputText = findViewById(R.id.inp_text);
        inputText.setText(String.valueOf(angka));

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        inputText = findViewById(R.id.inp_text);
        String input = inputText.getText().toString();
        myEdit.putString("input", input);
        myEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String input = sharedPreferences.getString("input", "");
        inputText = findViewById(R.id.inp_text);
        inputText.setText(input);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
//            Log.d("nilai", savedInstanceState.getString("nilai"));
            txtCount = findViewById(R.id.txt_count);
            angka = savedInstanceState.getInt("angka");
            txtCount.setText(String.valueOf(angka));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("nilai", "kena");
        outState.putInt("angka", angka);
    }

    public void countClick(View view){
        angka++;
        txtCount = findViewById(R.id.txt_count);
        txtCount.setText(String.valueOf(angka));
    }

    public void nextClick(View view){
        Intent k = new Intent(this, TestIntent.class);
        k.putExtra("joss", "wkwk");
        startActivity(k);
    }
}