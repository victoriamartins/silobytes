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
}
