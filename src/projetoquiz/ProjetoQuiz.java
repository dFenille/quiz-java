/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoquiz;

import java.util.ArrayList;
import java.util.Scanner;
import projetoquiz.Model.Participante;
import projetoquiz.Model.Quiz;

/**
 *
 * @author ENC-BACKEND
 */
public class ProjetoQuiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcao = 1;
        Quiz quiz = new Quiz();
        ArrayList<Participante> a = new ArrayList<>();

        do {
            Scanner input_start = new Scanner(System.in);
            if (opcao == 1) {
                System.out.println("------ BEM VINDO AO QUIZ  -----");
                System.out.println("Digite 0 - para sair");
                System.out.println("Digite 1 - para iniciar");
                
                opcao = input_start.nextInt();
            } else {
                System.out.println("Digite 0 - para sair");
                System.out.println("Digite 2 - para continuar");
                opcao = input_start.nextInt();
            }

            if (opcao > 0) {
                Scanner inputQuiz = new Scanner(System.in);
               
                System.out.printf("Qual é o seu nome?");
                String inputResult = inputQuiz.nextLine();

                Participante participante = new Participante();
                participante.setNome(inputResult);

                System.out.printf("Top, Agora o cpf?");
                inputResult = inputQuiz.nextLine();
                participante.setCpf(inputResult);

                if (participante != null) {
                    a.add(participante);
                }
                
                opcao = 2;
                for (int i = 0; i < a.size(); i++) {
                    System.out.println(a.get(i).getNome()+" - "+a.get(i).getCpf());
                }
            }

        } while (opcao != 0);

    }
}
