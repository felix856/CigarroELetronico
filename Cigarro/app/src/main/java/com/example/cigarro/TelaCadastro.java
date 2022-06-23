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

import java.lang.ref.Reference;
import java.util.ArrayList;

public class TelaCadastro extends AppCompatActivity {
    EditText login,senha,idade,anosDeFumo;
    EditText cigarroCadastro, vaperCadastro;
    boolean fodinha = false;
    ArrayList<Usuario> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        getSupportActionBar().hide();
        listaDeUsers();
        login = findViewById(R.id.loginCadastro);
        senha = findViewById(R.id.senhaCadastro);
        idade = findViewById(R.id.idadeCadastro);
        anosDeFumo = findViewById(R.id.anosDeFumoCadastro);
        cigarroCadastro = findViewById(R.id.cigarroCadastro);
        vaperCadastro = findViewById(R.id.vaperCadastro);


    }
    public void print(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
    public void cadastrar(View v){
        String log = login.getText().toString();
        String sen = senha.getText().toString();
        int ida = Integer.parseInt(idade.getText().toString());
        int  adf = Integer.parseInt(anosDeFumo.getText().toString());
        int cigarro = Integer.parseInt(cigarroCadastro.getText().toString());
        int vaper = Integer.parseInt(vaperCadastro.getText().toString());

        if(log.equals("") || sen.equals("") || ida == 0 || adf == 0 || cigarro == 0|| vaper == 0){
            print("Selecione tudo");
        }
        else{
        boolean existe = false;

    login.setText("");
    senha.setText("");
    idade.setText("");
    anosDeFumo.setText("");
    if(users.isEmpty()){
        Usuario novoUsuario = new Usuario(log,sen,adf,ida,cigarro,vaper);
        novoUsuario.salvarBD();
    }else {
        for (Usuario u : users) {
            if (u.login.equals(log)) {
                existe = true;
            }
        }
        if (existe) {
            Toast.makeText(this, "Usuario já existe", Toast.LENGTH_LONG).show();
        } else if (!existe) {
            Usuario novoUsuario = new Usuario(log, sen, adf, ida, 1, 1);
            novoUsuario.salvarBD();
            print("Usuario criado");

            TelaLogin.fodinha = fodinha;
            TelaLogin.users = users;
            irParaOLogin();
        }
    }
    }



    }
    public void listaDeUsers(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Usuario");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot d : snapshot.getChildren()){
                    Usuario u = d.getValue(Usuario.class);
                    users.add(u);
                    fodinha = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void irParaOLogin(){
        Intent i = new Intent(this,TelaLogin.class);
        startActivity(i);
    }
}