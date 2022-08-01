package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;

public class TelaStatus extends AppCompatActivity {

    static Usuario u;
    ImageView p1,p2, p3, p4, p5, p6, p7, p8, p9,p10;
    TextView tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_status);
        getSupportActionBar().hide();
        tempo = findViewById(R.id.tempoSemFumo);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        p9 = findViewById(R.id.p9);
        p10= findViewById(R.id.p10);
        //--------------------------------
        p2.setVisibility(View.INVISIBLE);
        p3.setVisibility(View.INVISIBLE);
        p1.setVisibility(View.INVISIBLE);
        p2.setVisibility(View.INVISIBLE);
        p3.setVisibility(View.INVISIBLE);
        p4.setVisibility(View.INVISIBLE);
        p5.setVisibility(View.INVISIBLE);
        p6.setVisibility(View.INVISIBLE);
        p7.setVisibility(View.INVISIBLE);
        p8.setVisibility(View.INVISIBLE);
        p9.setVisibility(View.INVISIBLE);
        p10.setVisibility(View.INVISIBLE);
       // Toast.makeText(this, "X: "+p1.getX()+"\n Y: "+p1.getY(), Toast.LENGTH_LONG).show();
        setarTempoFoda();

    }

    public void setarTempoFoda() {

        int diaDeHoje = LocalDateTime.now().getDayOfYear();
        int anoDeAgora = LocalDateTime.now().getYear();
        int dias = (diaDeHoje - u.getUltimoDia());
        int ano = (anoDeAgora - u.getUltimoAno());

//        if (dias < 0) {
//            dias *= -1;
//        } if (ano < 0) {
//            ano *= -1;
//        }
       int diasSemFumo = dias + ano * 365;
       // Toast.makeText(this,"Ano de agora: "+anoDeAgora+"\n Ano que parou de fumar: "+u.getUltimoAno()+"\nDia de hoje: "+diaDeHoje+"\nDia que parou de fumar: "+u.getUltimoDia()+"\nAnos sem fumar: "+ano+"\nDias sem fuma: "+diasSemFumo ,Toast.LENGTH_LONG).show();

        tempo.setText(diasSemFumo+"");
        RecuperacaoDoCigas.dias = diasSemFumo;
        Economiza.dias = diasSemFumo;
        mudarPosicao(diasSemFumo);
    }

    public void mudarPosicao(int semFumo) {


        if (semFumo >= 0 && semFumo < 366) {//800 o topo, o mais baixo é 1490| diferença é 690
            p2.setVisibility(View.VISIBLE);
            p2.setX(210);p2.setY(-512- (int) 1.33*semFumo);//maximo -998
        } else if (semFumo > 365 && semFumo <= 730) {
            p2.setVisibility(View.VISIBLE);
            p3.setVisibility(View.VISIBLE);
            semFumo =semFumo-365;
            p2.setX(210);p2.setY(-800);//800?
            p3.setX(210);p3.setY(-512- (int) 1.33*semFumo);

        } else if (semFumo > 730 && semFumo <= 1095) {
            p3.setVisibility(View.VISIBLE);
            p3.setX(210);
            p3.setY(-800);
            semFumo =semFumo-365*2;
            p4.setVisibility(View.VISIBLE);
            p4.setX(210);p4.setY(-512- (int) 1.33*semFumo);
        } else if (semFumo > 1095 && semFumo <= 1460) {
            p4.setVisibility(View.VISIBLE);
            p4.setX(210);
            p4.setY(-800);
            semFumo =semFumo-365*3;
            p5.setVisibility(View.VISIBLE);
            p5.setX(210);p5.setY(-512- (int) 1.33*semFumo);
        } else if (semFumo > 1460 && semFumo <= 1825) {
            p5.setVisibility(View.VISIBLE);
            p5.setX(210);
            p5.setY(-800);
            semFumo =semFumo-365*4;
            p6.setVisibility(View.VISIBLE);
            p6.setX(210);p6.setY(-512- (int) 1.33*semFumo);
        } else if (semFumo > 1825 && semFumo <= 2190) {
            p6.setVisibility(View.VISIBLE);
            p6.setX(210);
            p6.setY(-800);
            semFumo =semFumo-365*5;
            p7.setVisibility(View.VISIBLE);
            p7.setX(210);p7.setY(-512- (int) 1.33*semFumo);
        } else if (semFumo > 2190 && semFumo <= 2555) {
            p7.setVisibility(View.VISIBLE);
            p7.setX(210);
            p7.setY(-800);
            semFumo =semFumo-365*6;
            p8.setVisibility(View.VISIBLE);
            p8.setX(210);p8.setY(-512- (int) 1.33*semFumo);
        } else if (semFumo > 2555 && semFumo <= 2920) {
            p8.setVisibility(View.VISIBLE);
            p8.setX(210);
            p8.setY(-800);
            semFumo =semFumo-365*7;
            p9.setVisibility(View.VISIBLE);
            p9.setX(210);p9.setY(-512- (int) 1.33*semFumo);
        } else if (semFumo > 2920 && semFumo <= 3285) {
            p9.setVisibility(View.VISIBLE);
            p9.setX(210);
            p9.setY(-800);
            semFumo =semFumo-365*8;
            p10.setVisibility(View.VISIBLE);
            p10.setX(210);p10.setY(-512- (int) 1.33*semFumo);
        }

    }

    public void botao(View v) {
        passarTela();
    }


    public void passarTela() {
        Intent i = new Intent(this, Inspiracao.class);
        startActivity(i);

    }
}