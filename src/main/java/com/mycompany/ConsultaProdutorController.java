package com.mycompany;

import com.mycompany.util.ArquivoProdutor;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaProdutorController {
    @FXML
    private TableView<Produtor> tbProdutor;
    @FXML
    private TableColumn<Produtor, String> colNome;
    @FXML
    private TableColumn<Produtor, String> colCpf;
    @FXML
    private TableColumn<Produtor, String> colTel;
    @FXML
    private TableColumn<Produtor, String> colNasc;

    private List<Produtor> produtores;

    private ObservableList<Produtor> listaProdutores; 
    
    TableView.TableViewSelectionModel<Produtor> selectionModel; 
    
    @FXML
    public void initialize() {
        produtores = ArquivoProdutor.listar();    
        colNome = new TableColumn("Nome");    
        colCpf = new TableColumn("CPF");
        colTel = new TableColumn("Telefone");
        colNasc = new TableColumn("Nascimento");
        
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome")); 
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf")); 
        colTel.setCellValueFactory(new PropertyValueFactory<>("telefone")); 
        colNasc.setCellValueFactory(new PropertyValueFactory<>("nascimento")); 
               
        tbProdutor.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);    
        listaProdutores = FXCollections.observableArrayList(produtores);        
        tbProdutor.getColumns().addAll(colNome, colNasc, colCpf, colTel);
        
        tbProdutor.setItems(listaProdutores);  
        selectionModel = tbProdutor.getSelectionModel(); 
        selectionModel.setSelectionMode(SelectionMode.SINGLE);  
    }
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
    
}