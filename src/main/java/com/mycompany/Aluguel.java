package com.mycompany;

import com.mycompany.Produtor;
import com.mycompany.Silo;
import java.io.Serializable;
import java.time.LocalDate;

public class Aluguel implements Serializable{
    Produtor produtor;
    Silo silo;
    double espacoAlugado;
    LocalDate fimAluguel, inicioAluguel;
    double total;
    boolean pago;

    public Aluguel(Produtor produtor, Silo silo, double espacoAlugado, LocalDate inicioAluguel) {
        this.produtor = produtor;
        this.silo = silo;
        this.espacoAlugado = espacoAlugado;
        this.inicioAluguel = inicioAluguel;
    }
    
    public Aluguel(Produtor produtor, Silo silo, double espacoAlugado, 
            LocalDate inicioAluguel, LocalDate fimAluguel, double total,
            boolean pago){
        this.produtor = produtor;
        this.silo = silo;
        this.espacoAlugado = espacoAlugado;
        this.inicioAluguel = inicioAluguel;
        this.fimAluguel = fimAluguel;
        this.total = total;
        this.pago = pago;
    }

    public Aluguel() {
        this.produtor = null;
        this.silo = null;
        this.espacoAlugado = 0;
        this.inicioAluguel = null;
        this.fimAluguel = null;
        this.total = 0;
        this.pago = false;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public Silo getSilo() {
        return silo;
    }

    public double getEspacoAlugado() {
        return espacoAlugado;
    }

    public LocalDate getFimAluguel() {
        return fimAluguel;
    }

    public LocalDate getInicioAluguel() {
        return inicioAluguel;
    }

    public double getTotal() {
        return total;
    }

    public boolean isPago() {
        return pago;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public void setSilo(Silo silo) {
        this.silo = silo;
    }

    public void setEspacoAlugado(double espacoAlugado) {
        this.espacoAlugado = espacoAlugado;
    }

    public void setFimAluguel(LocalDate fimAluguel) {
        this.fimAluguel = fimAluguel;
    }

    public void setInicioAluguel(LocalDate inicioAluguel) {
        this.inicioAluguel = inicioAluguel;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
}
