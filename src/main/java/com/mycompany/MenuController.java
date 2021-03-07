package com.mycompany;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {
    @FXML
    private void sair(){
        System.exit(0);
    }
    
    @FXML
    private void cadatrarUsuario() throws IOException{
        App.setRoot("novoUsuario");
    }
    
    @FXML
    private void cadastrarProdutor () throws IOException{
        App.setRoot("novoProdutor");
    }
    
    @FXML 
    private void cadastrarSilo() throws IOException{
        App.setRoot("novoSilo");
    }
    
    @FXML 
    private void consultarProdutor() throws IOException{
        App.setRoot("consultaProdutor");
    }
    
    @FXML 
    private void consultarSilo() throws IOException{
        App.setRoot("consultaSilo");
    }
    
    @FXML 
    private void cadastrarAluguel() throws IOException{
        App.setRoot("novoAluguel");
    }
}
