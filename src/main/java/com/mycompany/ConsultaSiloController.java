package com.mycompany;

import com.mycompany.modelo.Silo;
import com.mycompany.util.ArquivoSilo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class ConsultaSiloController {
    
    ArrayList<Silo> lista = ArquivoSilo.listar();
    int tamanhoLista = lista.size();
    int pos = -1;
    
    @FXML
    private TextField campoEndereco;

    @FXML
    private Slider sliderCapacidade;

    @FXML
    private CheckBox checkAlugado;

    @FXML
    private Slider sliderDisponivel;

    @FXML
    private Button btnProximo;

    @FXML
    private Button btnAnterior;
    
    @FXML
    private Label lblCont;
    
    @FXML
    public void initialize(){
        this.proximoSilo();
        this.campoEndereco.setEditable(false);
        this.sliderCapacidade.setDisable(true);
        this.sliderDisponivel.setDisable(true);
    }
    
    @FXML
    public void proximoSilo(){
        try {
            this.setPos(this.getPos() + 1);
            this.atualizaContagem();
            campoEndereco.setText(this.lista.get(this.pos).getEndereco());
            sliderCapacidade.setValue(this.lista.get(this.pos).getCapacidade());
            sliderDisponivel.setValue(this.lista.get(this.pos).getDisponivel());
            checkAlugado.setSelected(this.lista.get(this.pos).getAlugado());
        } catch (IndexOutOfBoundsException e) {
            this.setPos(this.getPos() - 1);
            this.atualizaContagem();
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }
    
    @FXML
    public void siloAnterior(){
        try {
            this.setPos(this.getPos() - 1);
            this.atualizaContagem();
            campoEndereco.setText(this.lista.get(this.pos).getEndereco());
            sliderCapacidade.setValue(this.lista.get(this.pos).getCapacidade());
            sliderDisponivel.setValue(this.lista.get(this.pos).getDisponivel());
            checkAlugado.setSelected(this.lista.get(this.pos).getAlugado());
        } catch (IndexOutOfBoundsException e) {
            this.setPos(this.getPos() + 1);
            this.atualizaContagem();
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }
    
    @FXML
    public void atualizaContagem(){
        int n = this.pos + 1;
        lblCont.setText(n + "/" + this.tamanhoLista);
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    @FXML 
    private void voltarMenu() throws IOException{
        App.setRoot("menu");
    }
    
}
