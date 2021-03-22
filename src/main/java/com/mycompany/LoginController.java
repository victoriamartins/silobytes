package com.mycompany;

import com.mycompany.util.Arquivo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    ArrayList<Usuario> lista = Arquivo.listar();
    
    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Label lblEsqueceu;

    @FXML
    private Button btnSair;   
    
    @FXML
    private Label lblErro;
    
    @FXML
    private void sair(){
        System.exit(0);
    }
    
    @FXML
    private void entrar() throws IOException{
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        
        for (Usuario u: lista) {
            if (u.getLogin().equals(usuario)
                    && u.getSenha().equals(senha)) {
                MenuController.logado = u;
                this.acessaMenu();
            }
        }
        lblErro.setText("Usuário e/ou senha incorretos.");
    }
    
    @FXML 
    private void acessaMenu() throws IOException{
        App.setRoot("menu");
    }
}
