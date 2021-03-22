package com.mycompany;

import com.mycompany.util.Arquivo;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AlteraUsuarioController {
    public static Usuario logado;
    @FXML
    private TextField campoLogin;
    @FXML
    private PasswordField campoSenha;
    @FXML
    private PasswordField campoSenhaConf;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField campoNome;
    @FXML
    private Button btnSalvar;
    @FXML
    private Label lblMsg;
    
    @FXML
    public void initialize(){
        campoLogin.setText(logado.getLogin());
        campoNome.setText(logado.getNome());
        campoSenha.setText(logado.getSenha());
    }
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("menu");
    }
    
    @FXML
    private void salvar(){
        try {
            String nome = campoNome.getText();
            String login = campoLogin.getText();
            String senha = campoSenha.getText();
            String confirmacao = campoSenhaConf.getText();
            if (!confirmacao.equals(senha)) {
                lblMsg.setText("As senhas não coincidem!");
            } else if (nome == null && senha == null && login == null) {
                lblMsg.setText("Campos vazios.");
            } else {
                Arquivo.alterar(new Usuario(login, nome, senha));
                App.setRoot("login");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
