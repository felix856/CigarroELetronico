package com.example.cigarro;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDateTime;

public class Usuario {
    String login,senha;
    int tempoDeFumante,idade;
    boolean cigarro_usados,vaper_usados;
    int ultimoDia;
    int diasSemFumar;
    int ultimoAno;
    int custoDiarioDoCigas;
    public Usuario() {
    }

    public Usuario(String login, String senha, int tempoDeFumante, int idade, boolean cigarro_usados, boolean vaper_usados,int custoDiarioDoCigas) {
        this.login = login;
        this.senha = senha;
        this.tempoDeFumante = tempoDeFumante;
        this.idade = idade;
        this.cigarro_usados = cigarro_usados;
        this.vaper_usados = vaper_usados;
        this.custoDiarioDoCigas = custoDiarioDoCigas;
    }

    public int getCustoDiarioDoCigas() {
        return custoDiarioDoCigas;
    }

    public void setCustoDiarioDoCigas(int custoDiarioDoCigas) {
        this.custoDiarioDoCigas = custoDiarioDoCigas;
    }

    public int getUltimoDia() {
        return ultimoDia;
    }

    public void setUltimoDia(int ultimoDia) {
        this.ultimoDia = ultimoDia;
    }

    public int getDiasSemFumar() {
        return diasSemFumar;
    }

    public void setDiasSemFumar(int diasSemFumar) {
        this.diasSemFumar = diasSemFumar;
    }

    public int getUltimoAno() {
        return ultimoAno;
    }

    public void setUltimoAno(int ultimoAno) {
        this.ultimoAno = ultimoAno;
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

    public boolean isCigarro_usados() {
        return cigarro_usados;
    }

    public void setCigarro_usados(boolean cigarro_usados) {
        this.cigarro_usados = cigarro_usados;
    }

    public boolean isVaper_usados() {
        return vaper_usados;
    }

    public void setVaper_usados(boolean vaper_usados) {
        this.vaper_usados = vaper_usados;
    }

    public void salvarBD(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Usuario").child(login).setValue(this);
    }
}
