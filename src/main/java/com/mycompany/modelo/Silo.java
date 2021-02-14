package com.mycompany.modelo;

import java.io.Serializable;

public class Silo implements Serializable{
    String endereco;
    double capacidade;
    boolean alugado;
    
    public Silo(String endereco, double capacidade, boolean alugado){
        this.endereco = endereco;
        this.capacidade = capacidade;
        this.alugado = alugado;
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
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
}
