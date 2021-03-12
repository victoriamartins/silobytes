package com.mycompany;

import java.io.Serializable;
import java.time.LocalDate;

public class Produtor implements Serializable{
    String nome, cpf, telefone;
    LocalDate nascimento;
    public Produtor () {
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.nascimento = null;
    }
    public Produtor (String nome, String cpf, LocalDate nascimento, 
            String telefone){
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }   

    @Override
    public String toString() {
        return this.getNome();
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
    public String getTelefone() {
        return this.telefone;
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
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
