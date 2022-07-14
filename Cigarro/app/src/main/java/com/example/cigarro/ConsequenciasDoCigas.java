package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConsequenciasDoCigas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consequencias_do_cigas);
    }
    public void voltarTela(View v){
        Intent i = new Intent(this,Inspiracao.class);
        startActivity(i);

    }
}