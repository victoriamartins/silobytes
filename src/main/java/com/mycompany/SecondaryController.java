package com.mycompany;

import com.mycompany.util.Arquivo;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController {
        
    @FXML
    private TableView<Usuario> tabela;
    @FXML
    private TableColumn<Usuario, String> colunaNome;
    @FXML
    private TableColumn<Usuario, String> colunaLogin;

    private List<Usuario> usuarios;

    private ObservableList<Usuario> listaUsuarios; 
    
    TableViewSelectionModel<Usuario> selectionModel; 
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    public void initialize() {
        usuarios = Arquivo.listar();    
        colunaNome = new TableColumn("Nome");    
        colunaLogin = new TableColumn("Login");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));   
        colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));        
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);    
        listaUsuarios = FXCollections.observableArrayList(usuarios);        
        tabela.getColumns().addAll(colunaNome, colunaLogin);
        tabela.setItems(listaUsuarios);  
        selectionModel = tabela.getSelectionModel(); 
        selectionModel.setSelectionMode(SelectionMode.SINGLE);  
    }
}