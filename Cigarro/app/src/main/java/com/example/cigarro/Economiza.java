package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Economiza extends AppCompatActivity {
 static int dias;
 static Usuario u;
 TextView dinheiro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economiza);
        getSupportActionBar().hide();
        dinheiro = findViewById(R.id.campoDinheiro);
        int economia = u.getCustoDiarioDoCigas()*dias;
        String textp = economia+"R$";
        dinheiro.setText(textp);
    }
}