package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LinearLayout extends AppCompatActivity {

    EditText inputText;
    TextView txtCount;
    int angka = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_linear_layout);
    }

    public void tambahClick(View view){
        angka++;
        txtCount = findViewById(R.id.text_count);
        txtCount.setText(String.valueOf(angka));
    }

    public void kurangClick(View view){
        if(angka>0){
            angka--;
            txtCount = findViewById(R.id.text_count);
            txtCount.setText(String.valueOf(angka));
        } else {
            Toast.makeText(getApplicationContext(),"Batas Minimum : 0", Toast.LENGTH_LONG).show();
        }

    }

    public void toastClick(View view){
        EditText text = findViewById(R.id.inp_text);
        Toast.makeText(getApplicationContext(),"Message : "+text.getText(), Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
//            Log.d("nilai", savedInstanceState.getString("nilai"));
            txtCount = findViewById(R.id.text_count);
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

}