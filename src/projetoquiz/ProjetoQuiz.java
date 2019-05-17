/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoquiz;

import java.util.ArrayList;
import java.util.Scanner;
import projetoquiz.Model.Participante;
import projetoquiz.Model.Pergunta;
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
        int controleQuiz = 0;
        Quiz quiz = new Quiz();
        
        quiz.setPerguntas(getListaPergunta());
        do {
            Scanner input_start = new Scanner(System.in);
            if (controleQuiz == 0) {
                System.out.println("------ BEM VINDO AO QUIZ  -----");
                System.out.println("Digite 0 - para sair");
                System.out.println("Digite 1 - para iniciar");

                controleQuiz = input_start.nextInt();
            } else {
                System.out.println(" ----- MENU -------");
                System.out.println("Digite 0 - para sair");
                System.out.println("Digite 1 - para continuar");
                System.out.println("Digite 2 - para mostrar o ranking");

                System.out.println(" ------------");

                controleQuiz = input_start.nextInt();
            }

            switch (controleQuiz) {
                case 1:

                    Scanner inputQuiz = new Scanner(System.in);

                    System.out.println("Qual é o seu nome?");
                    String inputResult = inputQuiz.nextLine();

                    Participante participante = new Participante();
                    participante.setNome(inputResult);

                    System.out.println("Top, Agora o cpf?");
                    inputResult = inputQuiz.nextLine();
                    participante.setCpf(inputResult);

                    System.out.println("---------------------");
                    System.out.println("Responda as perguntas abaixo:");
                    for (int i = 0; i < quiz.getPerguntas().size(); i++) {
                        System.out.println(quiz.getPerguntas().get(i).getPergunta());
                        for(int j = 0; j < quiz.getPerguntas().get(i).getRespostas().size(); j++ ){
                                System.out.println(quiz.getPerguntas().get(i).getRespostas().get(j));    
                        }
                    }
                    
                    if (participante != null) {
                        quiz.addParticipante(participante);
                    }
                    break;
                case 2:

                    System.out.println(" ----- RANKING -------");
                    System.out.println(" NOME ---- CPF ----- SALDO");
                    for (int i = 0; i < quiz.getParticipantes().size(); i++) {
                        System.out.println(quiz.getParticipantes().get(i).getNome() + " - " + quiz.getParticipantes().get(i).getCpf()+ " - " + String.valueOf(quiz.getParticipantes().get(i).getSaldo()));
                    }
                    System.out.println(" ----- RANKING -------");
                break;
                default:
                    System.out.println(" ----- OBRIGADO POR PARTICIPAR DO QUIZ -------");    
                break;
            }

        } while (controleQuiz != 0);

    }

    private static ArrayList<Pergunta> getListaPergunta() {
        
        ArrayList<Pergunta> listaPergunta = new ArrayList<>();
        ArrayList<String> listaResposta1 = new ArrayList<>();
        
        Pergunta pergunta1 = new Pergunta();
        pergunta1.setPergunta("Qual o ano que o Palmeiras foi campeão?");
        listaResposta1.add("1 - 1997");
        listaResposta1.add("2 - 1998");
        listaResposta1.add("3 - 1999");
        listaResposta1.add("4 - 2000");
        
        pergunta1.setRespostas(listaResposta1);
        listaPergunta.add(pergunta1);
        
        
        ArrayList<String> listaResposta2 = new ArrayList<>();
        Pergunta pergunta2 = new Pergunta();
        pergunta2.setPergunta("Qual o maior idolo do Palmeiras?");
        listaResposta2.add("1 - Ademir da Guia");
        listaResposta2.add("2 - Paulo Nunes");
        listaResposta2.add("3 - São Marcos");
        listaResposta2.add("4 - Dudu");
        pergunta2.setRespostas(listaResposta2);
        
        listaPergunta.add(pergunta2);
        
        return listaPergunta;
    }
}
