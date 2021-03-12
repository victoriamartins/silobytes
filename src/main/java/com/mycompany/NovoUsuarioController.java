package com.mycompany;

import com.mycompany.util.Arquivo;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NovoUsuarioController {
    @FXML
    private void cadastrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setNome(campoNome.getText());
        usuario.setSenha(campoSenha.getText());
        Arquivo.inserir(usuario);
        this.limparCampos();
    }
    
    @FXML
    private void limparCampos(){
        campoLogin.setText("");
        campoNome.setText("");
        campoSenha.setText("");
    }
    
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
    
    @FXML
    private TextField campoLogin;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoSenha;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSalvar;
}
