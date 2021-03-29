package com.mycompany;

import com.mycompany.util.ArquivoSilo;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaSiloController {
    public Silo selecao;
    @FXML
    private Button btnAlterar;
    @FXML
    private Label lblCap;
    @FXML
    private Label lblEnd;
    @FXML
    private TextField campoEndereco;
    @FXML
    private Slider campoCapac;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnSalvar;
    @FXML
    private Label lblMsg;
    @FXML
    private TableView<Silo> tbSilo;
    @FXML
    private TableColumn<Silo, String> colEndereco;
    @FXML
    private TableColumn<Silo, Double> colCapacidade;
    @FXML
    private TableColumn<Silo, Double> colDisponivel;
    @FXML
    private TableColumn<Silo, Boolean> colAlugado;
    private List<Silo> silos;
    private ObservableList<Silo> listaSilos;  
    TableView.TableViewSelectionModel<Silo> selectionModel; 

    @FXML
    public void initialize() {
        silos = ArquivoSilo.listar();    
        colEndereco = new TableColumn("Endereço");    
        colCapacidade = new TableColumn("Capacidade (ton)");
        colDisponivel = new TableColumn("Disponível (ton)");
        colAlugado = new TableColumn("Alugado");
        
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));   
        colCapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));  
        colDisponivel.setCellValueFactory(new PropertyValueFactory<>("disponivel"));  
        colAlugado.setCellValueFactory(new PropertyValueFactory<>("alugado")); 
               
        listaSilos = FXCollections.observableArrayList(silos);        
        tbSilo.getColumns().addAll(colEndereco, colCapacidade, colDisponivel, colAlugado);
        tbSilo.setItems(listaSilos);  
        selectionModel = tbSilo.getSelectionModel(); 
        selectionModel.setSelectionMode(SelectionMode.SINGLE);  
    }
    @FXML
    private void cancelar(){
        this.visibilidade(false);
    }
    @FXML
    public void visibilidade(boolean estado) {
        lblEnd.setVisible(estado);
        lblCap.setVisible(estado);
        campoEndereco.setVisible(estado);
        campoCapac.setVisible(estado);
        btnCancelar.setVisible(estado);
        btnSalvar.setVisible(estado);
    }
    @FXML
    private void copiarDados () {
        try {
            selecao = tbSilo.getSelectionModel().getSelectedItem();
            if (selecao != null) {
                this.visibilidade(true);
                campoEndereco.setText(selecao.getEndereco());
                campoCapac.setValue(selecao.getCapacidade());
            } else {
                lblMsg.setText("Selecione um registro.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    private void salvar(){
        try {
                Silo antigo = selecao;
                double espacoAlugado = 
                        antigo.getCapacidade() - antigo.getDisponivel();
                double novoDisponivel = campoCapac.getValue() - espacoAlugado;
                if (campoCapac.getValue() >= espacoAlugado) {
                Silo novo = new Silo(campoEndereco.getText(), campoCapac.getValue(),
                        false, novoDisponivel);
                if (novoDisponivel == 0) novo.setAlugado(true);

                ArquivoSilo.alterarCadastro(antigo, novo);

                lblMsg.setText("Dados alterados!");
                this.atualizaTabela();
                this.visibilidade(false);
            } else {
                lblMsg.setText("Capacidade menor que espaço ja alugado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar alteração de silo " + e);
        }
    }
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
    @FXML 
    private void atualizaTabela(){
        listaSilos.removeAll(listaSilos);
        silos = ArquivoSilo.listar();
        listaSilos = FXCollections.observableList(silos);
        tbSilo.setItems(listaSilos);  
    }
}
