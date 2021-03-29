package com.mycompany;

import com.mycompany.util.ArquivoAluguel;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuController {
    public static Usuario logado;
    @FXML
    private TableView<Aluguel> tbPendentes;
    @FXML
    private Label nomeLogado; 
    @FXML
    private Label loginLogado;
    @FXML
    private Button btnAtt;
    @FXML
    private TableColumn<Aluguel, Produtor> colNome;
    @FXML
    private TableColumn<Aluguel, Silo> colEndereco;
    @FXML
    private TableColumn<Aluguel, LocalDate> colDataInicial;
    @FXML
    private TableColumn<Aluguel, LocalDate> colDataFinal;
    @FXML
    private TableColumn<Aluguel, Double> colEspacoAlugado;
    
    private List<Aluguel> alugueis;
    private ObservableList<Aluguel> listaAlugueis; 
    TableView.TableViewSelectionModel<Aluguel> selectionModel; 
    
    @FXML
    private void initialize(){
        nomeLogado.setText(logado.getNome());
        loginLogado.setText(logado.getLogin());
                alugueis = ArquivoAluguel.listar();    
        
        colNome = new TableColumn("Produtor");    
        colEndereco = new TableColumn("Endereco do silo");
        colDataInicial = new TableColumn("Inicio do contrato");
        colDataFinal = new TableColumn("Fim do contrato");
        colEspacoAlugado = new TableColumn("Espaço alugado");

        colNome.setCellValueFactory(new PropertyValueFactory<>("produtor")); 
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("silo")); 
        colDataInicial.setCellValueFactory(new PropertyValueFactory<>("inicioAluguel")); 
        colDataFinal.setCellValueFactory(new PropertyValueFactory<>("fimAluguel"));
        colEspacoAlugado.setCellValueFactory(new PropertyValueFactory<>("espacoAlugado"));
        
        List<Aluguel> pendentes = new ArrayList<Aluguel>();
        for (Aluguel a: alugueis){
            if (!a.isPago() && a.getFimAluguel() == null) {
                pendentes.add(a);
            }
        }
        
        listaAlugueis = FXCollections.observableArrayList(pendentes);        
        tbPendentes.getColumns().addAll(colNome, colEndereco, colEspacoAlugado, 
                colDataInicial, colDataFinal);
        
        tbPendentes.setItems(listaAlugueis);  
        selectionModel = tbPendentes.getSelectionModel(); 
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML
    private void atualizaTabela(){
        listaAlugueis.removeAll(listaAlugueis);
        alugueis = ArquivoAluguel.listar();
        List<Aluguel> pendentes = new ArrayList<Aluguel>();
        for (Aluguel a: alugueis){
            if (!a.isPago() && a.getFimAluguel() == null) {
                pendentes.add(a);
            }
        }
        listaAlugueis = FXCollections.observableList(pendentes);
        tbPendentes.setItems(listaAlugueis);  
    }
    
    @FXML
    private void sair(){
        System.exit(0);
    }
    
    @FXML
    private void cadatrarUsuario() throws IOException{
        App.setRoot("novoUsuario");
    }
    
    @FXML
    private void consultarUsuario() throws IOException{
        App.setRoot("consultaUsuario");
    }
    
    @FXML
    private void cadastrarProdutor () throws IOException{
        App.setRoot("novoProdutor");
    }
    
    @FXML 
    private void cadastrarSilo() throws IOException{
        App.setRoot("novoSilo");
    }
    
    @FXML 
    private void consultarProdutor() throws IOException{
        App.setRoot("consultaProdutor");
    }
    
    @FXML 
    private void consultarSilo() throws IOException{
        App.setRoot("consultaSilo");
    }
    
    @FXML 
    private void cadastrarAluguel() throws IOException{
        App.setRoot("novoAluguel");
    }
    
    @FXML 
    private void trocarUsuario() throws IOException{
        App.setRoot("login");
    }
    
    @FXML 
    private void consultarAluguel() throws IOException{
        App.setRoot("consultaAluguel");
    }
    
    @FXML 
    private void alterarMeusDados() throws IOException{
        AlteraUsuarioController.logado = this.logado;
        App.setRoot("alteraUsuario");
    }
}
