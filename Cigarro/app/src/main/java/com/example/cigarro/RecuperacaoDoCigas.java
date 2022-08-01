package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RecuperacaoDoCigas extends AppCompatActivity {
    static int dias;
    TextView e1, e2, e3, e4, e5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperacao_do_cigas);
        getSupportActionBar().hide();
        e1 = findViewById(R.id.dia1);
        e2 = findViewById(R.id.dia2);
        e3 = findViewById(R.id.semana2);
        e4 = findViewById(R.id.anos5);
        e5 = findViewById(R.id.anos15);
        conquistasAdquiridas();



    }
    public void conquistasAdquiridas(){
        if (dias >= 1) {
            e1.setTextColor(getResources().getColor(R.color.verdinhoMaisClaro));
        }
        if (dias >= 2) {
            e2.setTextColor(getResources().getColor(R.color.verdinhoMaisClaro));
        }
        if (dias >= 14) {
            e3.setTextColor(getResources().getColor(R.color.verdinhoMaisClaro));
        }
        if (dias >= 1825) {
            e4.setTextColor(getResources().getColor(R.color.verdinhoMaisClaro));
        }
        if (dias >= 5475) {
            e5.setTextColor(getResources().getColor(R.color.verdinhoMaisClaro));
        }
    }
    public void voltar(View v){
        Intent i = new Intent(this, Inspiracao.class); startActivity(i);
    }
}