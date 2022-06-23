package com.example.cigarro;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Usuario {
    String login,senha;
    int tempoDeFumante,idade;
    int cigarro_usados,vaper_usados;

    public Usuario() {
    }

    public Usuario(String login, String senha, int tempoDeFumante, int idade, int cigarro_usados, int vaper_usados) {
        this.login = login;
        this.senha = senha;
        this.tempoDeFumante = tempoDeFumante;
        this.idade = idade;
        this.cigarro_usados = cigarro_usados;
        this.vaper_usados = vaper_usados;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTempoDeFumante() {
        return tempoDeFumante;
    }

    public void setTempoDeFumante(int tempoDeFumante) {
        this.tempoDeFumante = tempoDeFumante;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCigarro_usados() {
        return cigarro_usados;
    }

    public void setCigarro_usados(int cigarro_usados) {
        this.cigarro_usados = cigarro_usados;
    }

    public int getVaper_usados() {
        return vaper_usados;
    }

    public void setVaper_usados(int vaper_usados) {
        this.vaper_usados = vaper_usados;
    }

    public void salvarBD(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Usuario").child(login).setValue(this);
    }
}
