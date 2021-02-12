package com.mycompany.util;

import com.mycompany.modelo.Produtor;
import com.mycompany.modelo.Usuario;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArquivoTest {
    
    public ArquivoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
/*
    @org.junit.jupiter.api.Test
    public void testInserir() {
        Usuario u = new Usuario("Bob", "Bob esponja", "123");
        Arquivo.inserir(u);
    }
 
    @org.junit.jupiter.api.Test
    public void testInserirProdutor(){
        Produtor p = new Produtor("João", "4567891564", "19670124");
        ArquivoProdutor.inserir(p);
    }
    
    @org.junit.jupiter.api.Test
    public void testListar(){
        ArrayList<Usuario> lista = Arquivo.listar();
        for(Usuario u:lista){
            System.out.println(u.getNome());
        }
    }
    */
    @org.junit.jupiter.api.Test
    public void testListarProdutor(){
        ArrayList<Produtor> lista = ArquivoProdutor.listar();
        for(Produtor p:lista){
            System.out.println("*********");
            System.out.println(p.getNome());
        }
    }
    



}
