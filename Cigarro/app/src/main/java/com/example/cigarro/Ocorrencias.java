package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ocorrencias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocorrencias);
    }
    public void botao(View v){
        passarTela();
    }
    public void passarTela(){
        Intent i = new Intent(this,TelaStatus.class);
        startActivity(i);
    }
}