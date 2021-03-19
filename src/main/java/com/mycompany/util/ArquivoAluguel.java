package com.mycompany.util;

import com.mycompany.Aluguel;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArquivoAluguel {
    public static void inserir(Aluguel aluguel){
        try {
            ArrayList<Aluguel> atual = listar();
            atual.add(aluguel);
            FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_ALUGUEL);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir aluguel.");
        }
    }
    public static ArrayList<Aluguel> listar(){
        ArrayList<Aluguel> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.ARQUIVO_ALUGUEL);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Aluguel>) ois.readObject();
            ois.close();
            return lista;
        } catch (EOFException e){
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao carregar alugueis." + e.getClass());
        }
        return lista;
    }
    public static void alterar(Aluguel alteracoes) {
        ArrayList<Aluguel> lista = listar();
        try {
            for (Aluguel a: lista) {
                if (a.getInicioAluguel().equals(alteracoes.getInicioAluguel())
                        && a.getEspacoAlugado() == alteracoes.getEspacoAlugado()
                        && a.getProdutor().getNome().equals(alteracoes.getProdutor().getNome())
                        && a.getSilo().getEndereco().equals(alteracoes.getSilo().getEndereco())) {
                    a.setFimAluguel(alteracoes.getFimAluguel());
                    a.setPago(alteracoes.isPago());
                    a.setTotal(alteracoes.getTotal());
                    FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_ALUGUEL);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(lista);
                    oos.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }
    public static void alterarProdutor(Aluguel alteracoes) {
        ArrayList<Aluguel> lista = listar();
        try {
            for (Aluguel a: lista) {
                if (a.getProdutor().getCpf().equals(alteracoes.getProdutor().getCpf())) {
                    a.setProdutor(alteracoes.getProdutor());
                    FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_ALUGUEL);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(lista);
                    oos.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }
}
