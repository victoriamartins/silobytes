package com.mycompany;

import com.mycompany.util.ArquivoSilo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class NovoSiloController {
    @FXML
    private TextField campoEndereco;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField campoCidade;
    @FXML
    private Button btnLimpar;
    @FXML
    private Button btnCadastrar;  
    @FXML
    private Slider campoCapacidade;
    @FXML
    private ComboBox<String> comboEstado;
   
    private ArrayList<String> lista = new ArrayList<String>();
    
    @FXML 
    public void initialize(){
        this.lista.add("AC");
        this.lista.add("AL");
        this.lista.add("AP");
        this.lista.add("AM");
        this.lista.add("BA");
        this.lista.add("CE");
        this.lista.add("ES");
        this.lista.add("GO");
        this.lista.add("MA");
        this.lista.add("MT");
        this.lista.add("MS");
        this.lista.add("MG");
        this.lista.add("PA");
        this.lista.add("PB");
        this.lista.add("PR");
        this.lista.add("PE");
        this.lista.add("PI");
        this.lista.add("RJ");
        this.lista.add("RN");
        this.lista.add("RO");
        this.lista.add("RR");
        this.lista.add("SC");
        this.lista.add("SP");
        this.lista.add("SE");
        this.lista.add("TO");
        this.lista.add("DF");
        ObservableList<String> obsLista = 
                FXCollections.observableList(lista);
        comboEstado.setItems(obsLista);
    }
    
    @FXML
    private void cadastrarSilo(){
        if (campoEndereco.getText() != ""
                && campoCidade.getText() != ""
                && !comboEstado.getValue().equals("")
                && campoCapacidade.getValue() != 0) {
            String endereco = campoEndereco.getText() + " " + 
                    campoCidade.getText() + " - " + comboEstado.getValue();
            double capacidade = campoCapacidade.getValue();
            try {
                Silo silo = new Silo(endereco, capacidade, false);
                ArquivoSilo.inserir(silo);
                lblMsg.setText("Silo cadastrado!");
                limparCampos();
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar silo!");
            }
        } else {
            lblMsg.setText("Campo vazio!");
        }
    }
    @FXML
    private void limparCampos(){
        campoEndereco.setText("");
        campoCidade.setText("");
        comboEstado.setValue("PR");
        campoCapacidade.setValue(0);
    }
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
}
