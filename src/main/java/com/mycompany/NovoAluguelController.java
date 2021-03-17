package com.mycompany;

import com.mycompany.util.ArquivoAluguel;
import com.mycompany.util.ArquivoProdutor;
import com.mycompany.util.ArquivoSilo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class NovoAluguelController {
    ArrayList<Produtor> lista = ArquivoProdutor.listar();
    ObservableList<Produtor> obsLista = FXCollections.observableList(lista);
    
    ArrayList<Silo> listaSilo = ArquivoSilo.listar();
    int tamanhoListaSilo = listaSilo.size();
    List<Silo> disponiveis = new ArrayList<>();
    
    @FXML
    private ComboBox<Produtor> comboProdutor;

    @FXML
    private ComboBox<Silo> comboSilo;

    @FXML
    private Slider sliderEspaco;

    @FXML
    private DatePicker dataAluguel;

    @FXML
    private Button btnCadastrar;
    
    @FXML
    private Button btnLimpar;
    
    @FXML
    private Label lblMsg;
    
    
    public void initialize(){
        comboProdutor.setItems(obsLista);
        this.povoarSilo();
    }
    
    private void povoarSilo(){
        for (Silo s: listaSilo) {
            if(s.getAlugado() == false) {
                disponiveis.add(s);
            }
        }
        ObservableList<Silo> obsListaSilo = FXCollections.observableArrayList(disponiveis);
        comboSilo.setItems(obsListaSilo);
    }
    
    @FXML 
    public void cadastrar(){
        Silo silo = comboSilo.getValue();
        Produtor produtor = comboProdutor.getValue();
        double espaco = sliderEspaco.getValue();
        LocalDate dataInicio = dataAluguel.getValue();
        
        if (dataInicio != null && produtor != null && silo != null) {
            if (espaco > silo.getDisponivel()) {
                lblMsg.setText("O silo não tem capacidade para " + espaco 
                        + " toneladas.");
            } else {
                double novoDisponivel = silo.getDisponivel() - espaco;
                Silo alterado = new Silo(silo.getEndereco(), silo.getCapacidade(), 
                        false, novoDisponivel);

                if (novoDisponivel == 0) {
                    alterado.setAlugado(true);
                }           

                Aluguel novo = new Aluguel(produtor, alterado, espaco, dataInicio);
                ArquivoAluguel.inserir(novo);
                ArquivoSilo.alterar(alterado);
                lblMsg.setVisible(true);
                lblMsg.setText("Aluguel cadastrado!");
                this.limpar();
            }
        }
    }
    
    @FXML
    private void limpar (){
        comboProdutor.setValue(null);
        comboSilo.setValue(null);
        sliderEspaco.setValue(0);
        dataAluguel.setValue(null);
    }
    
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
}
