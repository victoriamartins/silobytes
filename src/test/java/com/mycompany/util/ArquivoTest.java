package com.mycompany.util;

import com.mycompany.Aluguel;
import com.mycompany.Produtor;
import com.mycompany.Silo;
import com.mycompany.Usuario;
import java.time.LocalDate;
import java.time.Month;
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
    
    @org.junit.jupiter.api.Test
    public void testListarProdutor(){
        ArrayList<Produtor> lista = ArquivoProdutor.listar();
        for(Produtor p:lista){
            System.out.println("*********");
            System.out.println(p.getNome());
            System.out.println(p.getCpf());
            System.out.println(p.getNascimento());
        }
    }
    public void testInserirProdutor(){
        Produtor p = new Produtor("João", "4567891564", LocalDate.of(1950, 3, 2), "14998062934");
        ArquivoProdutor.inserir(p);
    }
    @org.junit.jupiter.api.Test
    public void testListarProdutor(){
        ArrayList<Produtor> lista = ArquivoProdutor.listar();
        for(Produtor p:lista){
            System.out.println("*********");
            System.out.println(p.getNome());
        }
    }
    
    @org.junit.jupiter.api.Test
    public void testInserirSilo() {
        Silo s = new Silo("Rodovia Teste, 404. Fartura - SP", 50.2, false);
        ArquivoSilo.inserir(s);
    }   
    @org.junit.jupiter.api.Test
    public void testListarSilos(){
        ArrayList<Silo> lista = ArquivoSilo.listar();
        for(Silo s:lista){
            System.out.println(s.getEndereco());
            System.out.println(s.getAlugado());
            System.out.println(s.getCapacidade());
        }
    }
    
    @org.junit.jupiter.api.Test
    public void testInserirAlguel() {
        Silo s = new Silo("Exemplo Aluguel, 702. Abatiá - PR", 78, false);
        Produtor p = new Produtor("Jéssica", "15478931577", LocalDate.of(1986, 12, 24), "1895878964");
        // comparar o quanto quer alugar com o disponivel
        Aluguel a = new Aluguel(p, s, 60, LocalDate.of(2021, 02, 10));
        // atualizar capacidade do silo
        ArquivoAluguel.inserir(a);
    }
    @org.junit.jupiter.api.Test
    public void testListarAluguel(){
        ArrayList<Aluguel> lista = ArquivoAluguel.listar();
        for(Aluguel a:lista){
            System.out.println("*********");
            System.out.println(a.getProdutor().getNome());
            System.out.println(a.getSilo().getEndereco());
            System.out.println(a.getInicioAluguel());
        }
    }
    
     */
    @org.junit.jupiter.api.Test
    public void testListarAluguel(){
        ArrayList<Aluguel> lista = ArquivoAluguel.listar();
        for(Aluguel a:lista){
            System.out.println("*********");
            System.out.println(a.getProdutor().getNome());
            System.out.println(a.getSilo().getEndereco());
            System.out.println(a.getFimAluguel());
            System.out.println(a.getTotal());
        }
    }
}
