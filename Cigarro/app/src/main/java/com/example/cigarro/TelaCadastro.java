package com.example.cigarro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TelaCadastro extends AppCompatActivity {
    EditText login, senha, idade, anosDeFumo;
    ImageView cigarroCadastro, vaperCadastro;

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
        cigarroCadastro = findViewById(R.id.xcigarro);
        vaperCadastro = findViewById(R.id.xvaper);
        cigarroCadastro.setVisibility(View.INVISIBLE);
        vaperCadastro.setVisibility(View.INVISIBLE);


    }

    public void print(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void cadastrar(View v) {
        String log = login.getText().toString();
        String sen = senha.getText().toString();
        int ida = Integer.parseInt(idade.getText().toString());
        int adf = Integer.parseInt(anosDeFumo.getText().toString());

        if (log.equals("") || sen.equals("") || ida == 0 || adf == 0) {
            print("Selecione tudo");
        } else {
            boolean existe = false;

            login.setText("");
            senha.setText("");
            idade.setText("");
            anosDeFumo.setText("");
            if (users.isEmpty()) {
                Usuario novoUsuario = new Usuario(log, sen, adf, ida, cigarroCadastro.getVisibility() == View.VISIBLE, vaperCadastro.getVisibility() == View.VISIBLE, LocalDateTime.now());
                novoUsuario.salvarBD();
            } else {
                for (Usuario u : users) {
                    if (u.login.equals(log)) {
                        existe = true;
                    }
                }
                if (existe) {
                    Toast.makeText(this, "Usuario já existe", Toast.LENGTH_LONG).show();
                } else if (!existe) {
                    Usuario novoUsuario = new Usuario(log, sen, adf, ida, cigarroCadastro.getVisibility() == View.VISIBLE, vaperCadastro.getVisibility() == View.VISIBLE,LocalDateTime.now());
                    novoUsuario.salvarBD();
                    print("Usuario criado");

                    irParaOLogin();
                }
            }
        }
    }

    public void botaoMudaCigas(View v) {
        if (cigarroCadastro.getVisibility() == View.INVISIBLE) {
            cigarroCadastro.setVisibility(View.VISIBLE);
        } else {
            cigarroCadastro.setVisibility(View.INVISIBLE);
        }
    }

    public void botaoMudaVaper(View v) {
        if (vaperCadastro.getVisibility() == View.INVISIBLE) {
            vaperCadastro.setVisibility(View.VISIBLE);
        } else {
            vaperCadastro.setVisibility(View.INVISIBLE);
        }
    }

    public void listaDeUsers() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Usuario");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d : snapshot.getChildren()) {
                    Usuario u = d.getValue(Usuario.class);
                    users.add(u);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void irParaOLogin() {
        Intent i = new Intent(this, TelaLogin.class);
        startActivity(i);
    }
}