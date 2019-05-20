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
public class Quiz {

    private ArrayList<Pergunta> perguntas = new ArrayList<>();
    private ArrayList<Participante> participantes = new ArrayList<>();
   
    
    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }
    
    // INJEÇÃO DE DEPENDECIA
    public void setPerguntas(ArrayList<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    // INJEÇÃO DE DEPENDECIA
    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }
    
    public void addParticipante(Participante participante){
        this.participantes.add(participante);
    }
   
}
