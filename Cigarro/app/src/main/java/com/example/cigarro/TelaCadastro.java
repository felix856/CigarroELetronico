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
    EditText login, senha, idade, anosDeFumo, custoCigarro;
    ImageView cigarroCadastro, vaperCadastro;

    ArrayList<Usuario> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        getSupportActionBar().hide();
        listaDeUsers();
        for (Usuario i : users) {
            print(i + "");

        }

        login = findViewById(R.id.loginCadastro);
        senha = findViewById(R.id.senhaCadastro);
        idade = findViewById(R.id.idadeCadastro);
        anosDeFumo = findViewById(R.id.anosDeFumoCadastro);
        cigarroCadastro = findViewById(R.id.xcigarro);
        vaperCadastro = findViewById(R.id.xvaper);
        cigarroCadastro.setVisibility(View.INVISIBLE);
        vaperCadastro.setVisibility(View.INVISIBLE);
        custoCigarro = findViewById(R.id.campoCigarroPorDia);

    }

    public void print(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void cadastrar(View v) {
       // try {
            boolean vamoBora =true;
            String log = login.getText().toString();
            String sen = senha.getText().toString();

            int ida = Integer.parseInt(idade.getText().toString());
            int adf = Integer.parseInt(anosDeFumo.getText().toString());
            int custoPoDia = Integer.parseInt(custoCigarro.getText().toString());
            if (log.equals("") || sen.equals("")) {

                print("faltando o login e a senha");
                vamoBora = false;

            } else if (adf > 0) {
                if (Integer.parseInt(custoCigarro.getText().toString()) == 0) {
                    print("Selecione tudo");
                    vamoBora = false;
                } if (cigarroCadastro.getVisibility() == View.INVISIBLE && vaperCadastro.getVisibility() == View.INVISIBLE) {
                    vamoBora = false;
                    print("Selecione tudo");

                }


            } if(vamoBora) {
                boolean existe = false;

                login.setText("");
                senha.setText("");
                idade.setText("");
                anosDeFumo.setText("");
                custoCigarro.setText("");
                if (users.isEmpty()) {

                    Usuario novoUsuario = new Usuario(log, sen, adf, ida, cigarroCadastro.getVisibility() == View.VISIBLE, vaperCadastro.getVisibility() == View.VISIBLE, custoPoDia);
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

                        Usuario novoUsuario = new Usuario(log, sen, adf, ida, cigarroCadastro.getVisibility() == View.VISIBLE, vaperCadastro.getVisibility() == View.VISIBLE, custoPoDia);
                        int ultimoDia = LocalDateTime.now().getDayOfYear();
                        int ultimoAno = LocalDateTime.now().getYear();

                        novoUsuario.setUltimoAno(ultimoAno);
                        novoUsuario.setUltimoDia(ultimoDia);
                        novoUsuario.salvarBD();
                        print("Usuario criado");

                        irParaOLogin();
                    }
                }
            }
      //  } catch (Exception e) {
        //    print("Mano se digitou algo errado");
       // }
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