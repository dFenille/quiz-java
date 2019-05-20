/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoquiz.Model;

/**
 *
 * @author ENC-BACKEND
 */
public class Participante implements Comparable<Participante> {

    private String nome;
    private String cpf;
    private float saldo;

    public String getNome() {
        return nome;
    }
    // ENCAPSULAMENTO
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    // ENCAPSULAMENTO
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getSaldo() {
        return saldo;
    }

    // ENCAPSULAMENTO
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    
    //    METODO QUE ATUALIZA O SALDO
    public void addSaldo(float newSaldo) {
        this.saldo = this.saldo + newSaldo;
    }

    
    //METODO PARA ORDENAR LISTA, PRECISAMOS IMPLEMENTAR A CLASSE COMPARABLE
    @Override
    public int compareTo(Participante participanteCompara) {
        if (this.saldo > participanteCompara.getSaldo()) {
            return -1;
        }
        if (this.saldo < participanteCompara.getSaldo()) {
            return 1;
        }
        return 0;
    }

}
