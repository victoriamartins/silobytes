package com.mycompany;

import com.mycompany.util.Arquivo;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaUsuarioController {
    @FXML
    private TableView<Usuario> tbUsuario;
    @FXML
    private TableColumn<Usuario, String> colunaNome;
    @FXML
    private TableColumn<Usuario, String> colunaLogin;

    private List<Usuario> usuarios;

    private ObservableList<Usuario> listaUsuarios; 
    
    TableView.TableViewSelectionModel<Usuario> selectionModel; 
    
    @FXML
    public void initialize() {
        usuarios = Arquivo.listar();    
        colunaNome = new TableColumn("Nome");    
        colunaLogin = new TableColumn("Login");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));   
        colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));        
        tbUsuario.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);    
        listaUsuarios = FXCollections.observableArrayList(usuarios);        
        tbUsuario.getColumns().addAll(colunaNome, colunaLogin);
        tbUsuario.setItems(listaUsuarios);  
        selectionModel = tbUsuario.getSelectionModel(); 
        selectionModel.setSelectionMode(SelectionMode.SINGLE);  
    }
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
}
