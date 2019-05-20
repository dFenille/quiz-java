/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoquiz.Model;

import java.util.ArrayList;

/**
 *
 * @author ENC-BACKEND
 */
public class Pergunta {

    private String pergunta;
    private ArrayList<String> respostas;
    private int respostaCerta;
    private float valorAcerto = 10f;

    public Pergunta() {

    }

    public String getPergunta() {
        return pergunta;
    }

    // ENCAPSULAMENTO
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public ArrayList<String> getRespostas() {
        return respostas;
    }

    // INJECAO DE DEPENCIA
    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }

    public float getValorAcerto() {
        return valorAcerto;
    }
    
    // ENCAPSULAMENTO
    public void setValorAcerto(float valorAcerto) {
        this.valorAcerto = valorAcerto;
    }

    public int getRespostaCerta() {
        return respostaCerta;
    }

    // ENCAPSULAMENTO
    public void setRespostaCerta(int respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

}
