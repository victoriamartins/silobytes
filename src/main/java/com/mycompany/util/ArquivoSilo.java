package com.mycompany.util;

import com.mycompany.Silo;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArquivoSilo {
    public static void inserir(Silo silo){
        try {
            ArrayList<Silo> atual = listar();
            atual.add(silo);
            FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_SILO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir silo.");
        }
    }
    public static ArrayList<Silo> listar(){
        ArrayList<Silo> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.ARQUIVO_SILO);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Silo>) ois.readObject();
            ois.close();
            return lista;
        } catch (EOFException e){
            return lista;
        } catch (Exception e) {
            System.out.println("\nErro ao carregar silos.");
        }
        return lista;
    }    
        
    public static void alterar(Silo siloAlterar) {
        ArrayList<Silo> lista = listar();
        try {
            for(Silo s: lista){ 
                if(s.getEndereco().equals(siloAlterar.getEndereco())
                        && s.getCapacidade() == siloAlterar.getCapacidade()){  
                    s.setEndereco(siloAlterar.getEndereco());
                    s.setCapacidade(siloAlterar.getCapacidade());
                    s.setAlugado(siloAlterar.getAlugado());
                    s.setDisponivel(siloAlterar.getDisponivel());
                    FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_SILO);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(lista);
                    oos.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar lista!");
        }
    }
}
