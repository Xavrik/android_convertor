package com.itproger.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] weight = { "Тонны", "Киллограмы", "Граммы"};
    private float ton;
    private float kilo;
    private float gram;
    private EditText input_text;
    private TextView in_ton;
    private TextView in_kilo;
    private TextView in_grm;
    private String item;
    private DataBase dataBase;
    Button save_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_text = findViewById(R.id.input_text);
        in_ton = findViewById(R.id.in_ton);
        in_kilo = findViewById(R.id.in_kilo);
        in_grm = findViewById(R.id.in_gram);
        save_btn = findViewById(R.id.save_btn);
        spinner();
        inputText();



    }

    public void save(){
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

  ////spinner
    public void spinner(){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, weight);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                item = (String)parent.getItemAtPosition(position);
               inputText();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }


 ///input reaction
    public void inputText(){
    input_text.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            switch (item) {
                case "Тонны":
                    ton = Float.parseFloat(input_text.getText().toString());
                    kilo = Float.parseFloat(input_text.getText().toString()) * 1000;
                    gram = Float.parseFloat(input_text.getText().toString()) * 1000000;
                    in_ton.setText(String.valueOf(ton));
                    in_kilo.setText(String.valueOf(kilo));
                    in_grm.setText(String.valueOf(gram));
                    break;
                case "Киллограмы":
                    ton = Float.parseFloat(input_text.getText().toString()) / 0.001f;
                    kilo = Float.parseFloat(input_text.getText().toString());
                    gram = Float.parseFloat(input_text.getText().toString()) * 1000;
                    in_ton.setText(String.valueOf(ton));
                    in_kilo.setText(String.valueOf(kilo));
                    in_grm.setText(String.valueOf(gram));
                    break;

                case "Граммы":
                    ton = Float.parseFloat(input_text.getText().toString()) / 1000000;
                    kilo = Float.parseFloat(input_text.getText().toString()) * 0.001f;
                    gram = Float.parseFloat(input_text.getText().toString());
                    in_ton.setText(String.valueOf(ton));
                    in_kilo.setText(String.valueOf(kilo));
                    in_grm.setText(String.valueOf(gram));
                    break;

                case "":
                    ton =0;
                    kilo = 0;
                    gram = 0;
                    in_ton.setText(String.valueOf(ton));
                    in_kilo.setText(String.valueOf(kilo));
                    in_grm.setText(String.valueOf(gram));

                }
        }

        @Override
        public void afterTextChanged(Editable editable) {
                   }
    });
}



}