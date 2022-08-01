package com.example.cigarro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TelaLogin extends AppCompatActivity {

    EditText login,senha;
    //ArrayList<Usuario> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().hide();
        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);


    }

    public void print(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    public void loginMassa(View v){

        String log = login.getText().toString();
        String sen =senha.getText().toString();
        if(log.equals("") || sen.equals("")){
            Toast.makeText( this,"Pre encha os campos", Toast.LENGTH_SHORT).show();
        }else{

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Usuario");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    boolean passou = false;
                    for(DataSnapshot d : snapshot.getChildren()){
                        Usuario u = d.getValue(Usuario.class);
                        if(u.getLogin().equals(log) && u.getSenha().equals(sen)){
                          //  print(u.getUltimoDia()+"");
                            TelaStatus.u = u;
                            Economiza.u = u;
                            passarTela();
                            passou = true;
                        }
                    }
                    if(!passou){
                        print("Login ou senha wrong");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    private void passarTela() {
        Intent i = new Intent(this,Ocorrencias.class); //mudar para aperguntas motivacionais, 3 telas fragmentos
        startActivity(i);
    }
    public void irParaOCadastro(View v){
        Intent i = new Intent(this,TelaCadastro.class);
        startActivity(i);

    }

}