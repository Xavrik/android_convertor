package com.itproger.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private DataBase dataBase;
    private TextView out_ton;
    private TextView out_kilo;
    private TextView out_grm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        out_ton = findViewById(R.id.out_ton);
        out_kilo = findViewById(R.id.out_kilo);
        out_grm = findViewById(R.id.out_grm);



    }
}