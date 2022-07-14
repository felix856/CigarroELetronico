package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RecuperacaoDoCigas extends AppCompatActivity {
    static int dias;
    TextView e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperacao_do_cigas);
        e1 = findViewById(R.id.dia1);
        e2 = findViewById(R.id.dia2);
        e3 = findViewById(R.id.semana2);
        e4 = findViewById(R.id.anos5);
        e5 = findViewById(R.id.anos15);
                

    }
}