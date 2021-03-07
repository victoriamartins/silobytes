package com.mycompany;

import com.mycompany.modelo.Aluguel;
import com.mycompany.modelo.Produtor;
import com.mycompany.modelo.Silo;
import com.mycompany.util.ArquivoAluguel;
import com.mycompany.util.ArquivoProdutor;
import com.mycompany.util.ArquivoSilo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
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
    private Label lblMsg;
    
    
    public void initialize(){
        this.povoarProdutor();
        this.povoarSilo();
    }
    
    private void povoarProdutor(){
        ArrayList<Produtor> lista = ArquivoProdutor.listar();
        ObservableList<Produtor> obsLista = FXCollections.observableList(lista);
        comboProdutor.getItems().addAll(obsLista);
    }
    
    private void povoarSilo(){
        ArrayList<Silo> listaSilo = ArquivoSilo.listar();
        List<Silo> disponiveis = new ArrayList<>();
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
       
        if (silo.getCapacidade() < espaco) {
            lblMsg.setText("O silo não tem capacidade para " + espaco + " toneladas.");
        } else {
            // falta atualizar a quantia disponivel no silo depois de alugar
            Aluguel novo = new Aluguel(produtor, silo, espaco, dataInicio);
            ArquivoAluguel.inserir(novo);
        }
    }
    
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
}
