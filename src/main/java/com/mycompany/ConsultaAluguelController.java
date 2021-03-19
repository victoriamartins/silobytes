package com.mycompany;

import com.mycompany.util.ArquivoAluguel;
import com.mycompany.util.ArquivoSilo;
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
    private void atualizaTabela(){
        listaAlugueis.removeAll(listaAlugueis);
        alugueis = ArquivoAluguel.listar();
        listaAlugueis = FXCollections.observableList(alugueis);
        tbAluguel.setItems(listaAlugueis);  
    }
    @FXML
    private void finalizarAluguel() {
        try {
            selecao = tbAluguel.getSelectionModel().getSelectedItem();
            if (selecao.getFimAluguel() != null) {
                lblMsgErro.setText(("Aluguel já finalizado."));
            } else {
                visibilidade(true);
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
                
                Silo silo = selecao.getSilo();
                Silo altSilo = new Silo();
                
                if (silo.getAlugado()) { // se antes estava alugado, nao esta mais
                    altSilo.setAlugado(false);
                }
                
                altSilo.setEndereco(silo.getEndereco());
                altSilo.setCapacidade(silo.getCapacidade());
                System.out.println("Disp " + silo.getDisponivel() + " esp " + selecao.getEspacoAlugado());
                altSilo.setDisponivel(silo.getDisponivel() 
                        + selecao.getEspacoAlugado());
                
                ArquivoSilo.alterar(altSilo);
                ArquivoAluguel.alterar(alteracoes);
                cancelar(); // limpa campos, esconde, retira selecao
                atualizaTabela();
                lblMsgErro.setText("Aluguel finalizado!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } 
    @FXML
    public void pagar(){
        try {
            selecao = tbAluguel.getSelectionModel().getSelectedItem();
            if (selecao.isPago() == true) {
                lblMsgErro.setText("O aluguel já está pago!");
            } else if (selecao.getFimAluguel() == null) { // nao esta pago nem finalizado
                lblMsgErro.setText("Finalize o aluguel para que possa ser pago!");
            } else { // finalizado e nao pago
                alteracoes = null;
                long diferencaEmDias = ChronoUnit.DAYS.between(
                selecao.getInicioAluguel(),
                selecao.getFimAluguel());
                
                this.total = diferencaEmDias * 17.5;
                alteracoes = new Aluguel(selecao.getProdutor(), 
                        selecao.getSilo(), 
                        selecao.getEspacoAlugado(), 
                        selecao.getInicioAluguel(), 
                        selecao.getFimAluguel(), total, true);
                lblMsgErro.setText("Pagamento realizado.");
                ArquivoAluguel.alterar(alteracoes);
                cancelar();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }   
    @FXML
    public void cancelar(){
        selecao = null;
        limparCampos();
        visibilidade(false);
    }
    private void limparCampos(){
        dtFinal.setValue(null);
        campoTotal.setText("");
        cbPago.setSelected(false);
    }
    private void visibilidade(boolean estado) {
        lbl1.setVisible(estado);
        lbl2.setVisible(estado);
        dtFinal.setVisible(estado);
        cbPago.setVisible(estado);
        campoTotal.setVisible(estado);
        btnSalvar.setVisible(estado);
        btnCancelar.setVisible(estado);
    }
    
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
    @FXML
    private Button btnFinalizar;
    @FXML
    private Button btnPagar;
    @FXML
    private Button btnCancelar;
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
}