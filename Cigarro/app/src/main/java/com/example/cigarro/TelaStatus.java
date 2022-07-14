package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDateTime;

public class TelaStatus extends AppCompatActivity {

    public static Usuario u;
    TextView tempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_status);
        getSupportActionBar().hide();
        tempo = findViewById(R.id.tempoSemFumo);
        setarTempoFoda();
    }
    public void setarTempoFoda(){
        int diaDeHoje = LocalDateTime.now().getDayOfYear();
        int anoDeAgora = LocalDateTime.now().getYear();
        int dias = (diaDeHoje - u.getUltimoDia());
        int ano = (anoDeAgora-u.getUltimoAno());
        if(dias <0 && ano <0) {
            dias*=-1;
            ano*=-1;
        }else if(dias < 0){
            dias*=-1;
        }else if (ano <0){
            ano*=-1;
        }
        int diasSemFumo = dias+ano*365;
        tempo.setText(diasSemFumo+"");
        RecuperacaoDoCigas.dias = diasSemFumo;
    }
    public void botao(View v){
        passarTela();
    }
    public void passarTela(){
        Intent i = new Intent(this, Inspiracao.class);
        startActivity(i);

    }
}