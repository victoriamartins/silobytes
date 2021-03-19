package com.mycompany;

import com.mycompany.util.ArquivoAluguel;
import com.mycompany.util.ArquivoProdutor;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaProdutorController {
    private Produtor selecao;
    
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
    private void copiarDados(){
        try {
            selecao = tbProdutor.getSelectionModel().getSelectedItem();
            campoNome.setText(selecao.getNome());
            campoCpf.setText(selecao.getCpf());
            campoNasc.setValue(selecao.getNascimento());
            campoTel.setText(selecao.getTelefone());
            this.visualizacao(true);
            lblMsg.setText("");
        } catch (Exception e) {
            lblMsg.setText("Selecione um registro!");
        }
        
    }
    @FXML
    private void salvar(){
        try {
            if (campoNome != null && campoCpf != null && campoNasc != null 
                    && campoTel != null) {
                Produtor novo = new Produtor(campoNome.getText(), 
                        campoCpf.getText(), 
                        campoNasc.getValue(), 
                        campoTel.getText());
                ArquivoProdutor.alterar(novo);
                ArrayList<Aluguel> listaAluguel = ArquivoAluguel.listar();
                for (Aluguel a: listaAluguel) {
                    if (a.getProdutor().getCpf().equals(selecao.getCpf())){
                        a.setProdutor(novo);
                        ArquivoAluguel.alterarProdutor(a);
                        break;
                    }
                }
                lblMsg.setText("Dados alterados!");
                atualizaTabela();
                this.cancelar();    
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    private void cancelar(){
        campoNome.setText("");
        campoCpf.setText("");
        campoNasc.setValue(null);
        campoTel.setText("");
        visualizacao(false);
    }
    @FXML 
    private void atualizaTabela(){
        listaProdutores.removeAll(listaProdutores);
        produtores = ArquivoProdutor.listar();
        listaProdutores = FXCollections.observableList(produtores);
        tbProdutor.setItems(listaProdutores);  
    }
    @FXML
    private void visualizacao(boolean estado){
        campoNome.setVisible(estado);
        campoNasc.setVisible(estado);
        campoCpf.setVisible(estado);
        campoTel.setVisible(estado);
        lbl1.setVisible(estado);
        lbl2.setVisible(estado);
        lbl3.setVisible(estado);
        lbl4.setVisible(estado);
        btnSalvar.setVisible(estado);
        btnCancelar.setVisible(estado);
    }
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
    
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
    @FXML
    private Button btnAlterar;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoTel;
    @FXML
    private TextField campoCpf;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnSalvar;
    @FXML
    private DatePicker campoNasc;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lblMsg;
}