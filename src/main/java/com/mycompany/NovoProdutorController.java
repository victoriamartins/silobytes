package com.mycompany;

import com.mycompany.util.ArquivoProdutor;
import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NovoProdutorController {
    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCPF;

    @FXML
    private DatePicker campoNascimento;

    @FXML
    private Button btnLimpar;
    
    @FXML
    private Label lblMsg;
    
    @FXML
    private TextField campoTel;

    @FXML
    private void cadastrarProdutor(){
        String nome = campoNome.getText();
        String cpf = campoCPF.getText();
        LocalDate nascimento = campoNascimento.getValue();
        String telefone = campoTel.getText();
        Produtor p = new Produtor(nome, cpf, nascimento, telefone);
        try {
            ArquivoProdutor.inserir(p);
            this.limparCampos();
            lblMsg.setText(nome + " cadastrado com sucesso!");
        } catch (Exception e) {
            lblMsg.setText("Erro ao cadastrar!");
        }
    }
    
    @FXML 
    private void limparCampos(){
        campoCPF.setText("");
        campoNascimento.getEditor().clear();
        campoNome.setText("");
    }

    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
}
