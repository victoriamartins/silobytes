package com.mycompany.modelo;

import java.io.Serializable;

public class Silo implements Serializable{
    String endereco;
    double capacidade;
    boolean alugado;
    double disponivel;
    
    public Silo(String endereco, double capacidade, boolean alugado){
        this.endereco = endereco;
        this.capacidade = capacidade;
        this.alugado = alugado;
        this.disponivel = capacidade;
    }
    public String getEndereco() {
        return endereco;
    }
    public double getCapacidade() {
        return capacidade;
    }
    public boolean getAlugado() {
        return alugado;
    }
    public double getDisponivel() {
        return disponivel;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
    public void setDisponivel(double disponivel) {
        this.disponivel = disponivel;
    }
}
