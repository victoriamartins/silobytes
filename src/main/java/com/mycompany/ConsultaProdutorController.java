package com.mycompany;

import com.mycompany.modelo.Produtor;
import com.mycompany.util.ArquivoProdutor;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ConsultaProdutorController {
    ArrayList<Produtor> lista = ArquivoProdutor.listar();
    int pos = -1;
    
    @FXML
    private Button btnAnterior;

    @FXML
    private Button btnProximo;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCPF;

    @FXML
    private DatePicker campoNasc;

    @FXML
    private TextField campoTelefone;

    @FXML
    private Button btnAlterar;
    
    @FXML
    public void initialize(){
        this.proximoProdutor();
    }
   
    @FXML
    public void proximoProdutor(){
        try {
            this.setPos(this.getPos() + 1);
            campoNome.setText(this.lista.get(pos).getNome());
            campoNasc.setValue(this.lista.get(pos).getNascimento());
            campoCPF.setText(this.lista.get(pos).getCpf());
            campoTelefone.setText(this.lista.get(pos).getTelefone());
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }
    
    @FXML
    public void produtorAnterior(){
        try {
            this.setPos(this.getPos() - 1);
            campoNome.setText(this.lista.get(pos).getNome());
            campoNasc.setValue(this.lista.get(pos).getNascimento());
            campoCPF.setText(this.lista.get(pos).getCpf());
            campoTelefone.setText(this.lista.get(pos).getTelefone());
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }
    
    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }
    
}
