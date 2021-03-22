package com.mycompany.util;

import com.mycompany.Usuario;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Arquivo {
    public static void inserir(Usuario usuario){
        try {
            ArrayList<Usuario> atual = listar();
            atual.add(usuario);
            FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_USUARIO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(atual);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir usuário." + e);
        }
    }
    public static ArrayList<Usuario> listar(){
        ArrayList<Usuario> lista = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Info.ARQUIVO_USUARIO);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Usuario>) ois.readObject();
            ois.close();
            return lista;
        } catch (EOFException e){
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao carregar usuarios."+ e);
        }
        return lista;
    }
    public static void alterar(Usuario usuarioAlt) {
        ArrayList<Usuario> lista = listar();
        try {
            for(Usuario u: lista){ 
                if(usuarioAlt.getNome().equals(u.getNome())){  
                    u.setLogin(usuarioAlt.getLogin());
                    u.setSenha(usuarioAlt.getSenha());
                    FileOutputStream fos = new FileOutputStream(Info.ARQUIVO_USUARIO);
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
