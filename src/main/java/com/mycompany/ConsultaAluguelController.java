package com.mycompany;

import com.mycompany.util.ArquivoAluguel;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaAluguelController {
    Aluguel selecao;
    Aluguel alteracoes = new Aluguel();
    double total = -1;
    @FXML
    private Button btnFinalizar;
    @FXML
    private Button btnSalvar;
    @FXML
    private Label lblMsgErro;
    @FXML
    private TableView<Aluguel> tbAluguel;
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
    @FXML
    private TableColumn<Aluguel, Double> colTotal;
    @FXML
    private TableColumn<Aluguel, Boolean> colPago;
    @FXML
    private DatePicker dtFinal;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private TextField campoTotal;

    @FXML
    private CheckBox cbPago;
    
    private List<Aluguel> alugueis;

    private ObservableList<Aluguel> listaAlugueis; 
    
    TableView.TableViewSelectionModel<Aluguel> selectionModel; 
        
    @FXML
    public void initialize() {
        
        alugueis = ArquivoAluguel.listar();    
        
        colNome = new TableColumn("Produtor");    
        colEndereco = new TableColumn("Endereco");
        colDataInicial = new TableColumn("Inicio do contrato");
        colDataFinal = new TableColumn("Fim do contrato");
        colEspacoAlugado = new TableColumn("Espaço alugado");
        colTotal = new TableColumn("Total (R$)");
        colPago = new TableColumn("Pagamento realizado");
        
        colNome.setCellValueFactory(new PropertyValueFactory<>("produtor")); 
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("silo")); 
        colDataInicial.setCellValueFactory(new PropertyValueFactory<>("inicioAluguel")); 
        colDataFinal.setCellValueFactory(new PropertyValueFactory<>("fimAluguel"));
        colEspacoAlugado.setCellValueFactory(new PropertyValueFactory<>("espacoAlugado"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colPago.setCellValueFactory(new PropertyValueFactory<>("pago"));
                  
        listaAlugueis = FXCollections.observableArrayList(alugueis);        
        tbAluguel.getColumns().addAll(colNome, colEndereco, colEspacoAlugado, 
                colDataInicial, colDataFinal, colTotal, colPago);
        
        tbAluguel.setItems(listaAlugueis);  
        selectionModel = tbAluguel.getSelectionModel(); 
        selectionModel.setSelectionMode(SelectionMode.SINGLE);  
    }
    
    @FXML
    private void finalizarAluguel() {
        try {
            selecao = tbAluguel.getSelectionModel().getSelectedItem();
            if (selecao.getFimAluguel() != null) {
                lblMsgErro.setText(("Aluguel já finalizado."));
            } else {
                alteracoes.setProdutor(selecao.getProdutor());
                alteracoes.setSilo(selecao.getSilo());
                alteracoes.setEspacoAlugado(selecao.getEspacoAlugado());
                alteracoes.setInicioAluguel(selecao.getInicioAluguel());              
            }            
        } catch (NullPointerException e) {
            lblMsgErro.setText("Selecione uma linha.");
        } catch (Exception e) {
            System.out.println("Erro + " + e);
        }  
    }
    
    @FXML 
    public void calculaValor(){
        try {
            long diferencaEmDias = ChronoUnit.DAYS.between(
                selecao.getInicioAluguel(),
                dtFinal.getValue());
                
            this.total = diferencaEmDias * 17.5;
            campoTotal.setText("R$ " + total); 
        } catch (Exception e) {
            System.out.println("---> " + e);
        }
    }
    
    @FXML 
    public void salvarFinalizacao(){
        try {
            if (selecao != null && this.total != -1) {
                alteracoes.setPago(cbPago.isSelected());
                alteracoes.setTotal(this.total);
                alteracoes.setFimAluguel(dtFinal.getValue());
                ArquivoAluguel.alterar(alteracoes);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }

}
