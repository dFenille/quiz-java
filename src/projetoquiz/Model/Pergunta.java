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
    private float valorAcerto = 10f;

    public Pergunta(String pergunta, ArrayList<String> respostas) {
        this.pergunta = pergunta;
        this.respostas = respostas;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }

    public float getValorAcerto() {
        return valorAcerto;
    }

    public void setValorAcerto(float valorAcerto) {
        this.valorAcerto = valorAcerto;
    }
    

   
}
