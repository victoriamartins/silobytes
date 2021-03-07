package com.mycompany.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
    String login, nome, senha;
    public Usuario(){
        this.login = "";
        this.nome = "";
        this.senha = "";
    }
    public Usuario(String nome, String login, String senha){
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", nome=" + nome + ", senha=" + senha + '}';
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }   
}
