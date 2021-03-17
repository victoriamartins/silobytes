package com.mycompany.util;

import com.mycompany.Produtor;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArquivoProdutor {
    public static void inserir(Produtor produtor){
        try {
            ArrayList<Produtor> atual = listar();
            atual.add(produtor);
            FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_PRODUTOR);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir produtor.");
        }
    }
    public static ArrayList<Produtor> listar(){
        ArrayList<Produtor> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.ARQUIVO_PRODUTOR);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Produtor>) ois.readObject();
            ois.close();
            return lista;
        } catch (EOFException e){
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao carregar produtores.");
        }
        return lista;
    }
    public static void alterar(Produtor prodAlterar) {
        ArrayList<Produtor> lista = listar();
        try {
            for(Produtor p: lista){ 
                if(p.getCpf().equals(prodAlterar.getCpf())){  
                    p.setNome(prodAlterar.getNome());
                    p.setNascimento(prodAlterar.getNascimento());
                    p.setTelefone(prodAlterar.getTelefone());
                    
                    FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_PRODUTOR);
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
