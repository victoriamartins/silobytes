package com.mycompany;

import com.mycompany.modelo.Usuario;
import com.mycompany.util.Arquivo;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    ArrayList<Usuario> lista = Arquivo.listar();
    
    @FXML
    private TextField campoUsuario;

    @FXML
    private TextField campoSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Label lblEsqueceu;

    @FXML
    private Button btnSair;    
    
    @FXML
    private void sair(){
        System.exit(0);
    }
    
    @FXML
    private void entrar(){
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();
    }
}
