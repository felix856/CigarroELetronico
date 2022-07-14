package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inspiracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiracao);
        getSupportActionBar().hide();
    }
    public void voltarParaStatus(View view){
        Intent i = new Intent(this,TelaStatus.class);
        startActivity(i);
    }
    public void economiza(View v){
        Intent i = new Intent(this,Economiza.class);
        startActivity(i);
    }
    public void consequencias(View v){
        Intent i = new Intent(this,ConsequenciasDoCigas.class);
        startActivity(i);
    }
    public void telaDeRecuperacao(){
        Intent e = new Intent(this,RecuperacaoDoCigas.class);
        startActivity(e);
    }
    public void meditacao(View v){
        Intent i = new Intent(this,Meditacao.class);
        startActivity(i);
    }
    public void botaoDeRecuperacao(View v){
        telaDeRecuperacao();
    }
}