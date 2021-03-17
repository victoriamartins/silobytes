package com.mycompany;

import com.mycompany.util.ArquivoSilo;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaSiloController {
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
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
    
}
