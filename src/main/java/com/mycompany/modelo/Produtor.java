package com.mycompany.modelo;

import java.io.Serializable;

public class Produtor implements Serializable{
    String nome, cpf, nascimento;
    public Produtor () {
        this.nome = "";
        this.cpf = "";
        this.nascimento = "";
    }
    public Produtor (String nome, String cpf, String nascimento){
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNascimento() {
        return nascimento;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
