package com.mycompany.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Produtor implements Serializable{
    String nome, cpf;
    LocalDate nascimento;
    public Produtor () {
        this.nome = "";
        this.cpf = "";
        this.nascimento = null;
    }
    public Produtor (String nome, String cpf, LocalDate nascimento){
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
    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
