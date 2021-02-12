package com.mycompany;

import com.mycompany.modelo.Produtor;
import com.mycompany.util.ArquivoProdutor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private TextField campoNascimento;

    @FXML
    private Button btnLimpar;
    
    @FXML
    private Label lblMsg;

    @FXML
    private void cadastrarProdutor(){
        String nome = campoNome.getText();
        String cpf = campoCPF.getText();
        String nascimento = campoNascimento.getText();
        Produtor p = new Produtor(nome, cpf, nascimento);
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
        campoNascimento.setText("");
        campoNome.setText("");
    }
}
