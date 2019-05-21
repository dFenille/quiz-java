/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoquiz;

import java.util.ArrayList;
import java.util.Collections;
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
        
        // CONTROLE DO QUIZ INICIANDO ZERADO
        int controleQuiz = 0;
        // INICIA O OBJETO QUIZ
        Quiz quiz = new Quiz();
        // POPULA COM AS PERGUNTAS E RESPOSTAS
        quiz.setPerguntas(getListaPergunta());
        
        // INICIA O QUIZ
        do {
            Scanner input_start = new Scanner(System.in);
            
            // FAZ A VERIFICACAO DE CONTROLE DO QUIZ
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
                
            // ESTADOS DO CONTROLE DO QUIZ
            switch (controleQuiz) {
                case 1: // QUIZ
                    // INICIA O SCANNER/INPUT
                    Scanner inputQuiz = new Scanner(System.in);
                        
                    //captura o nome
                    System.out.println("Qual é o seu nome?");
                    String inputResult = inputQuiz.nextLine();
                        
                    // INICIA O OBJETO PARTICIPANTE
                    Participante participante = new Participante();
                    // SETA O NOME DO PARTICIPANTE QUE RECEBEU DO INPUT
                    participante.setNome(inputResult);
                    
                    // CAPTURA O CPF
                    System.out.println("Top, Agora o cpf?");
                    inputResult = inputQuiz.nextLine();
                    
                    // SETA O CPF DO PARTICIPANTE QUE RECEBEU DO INPUT
                    participante.setCpf(inputResult);
                    
                    
                    System.out.println("---------------------");
                    System.out.println("Responda as perguntas abaixo:");
                    
                    // PERCORRE DE AS PERGUNTAS DO QUIZ 
                    int inputAnswer;
                    
                    for (int i = 0; i < quiz.getPerguntas().size(); i++) {
                        System.out.println(quiz.getPerguntas().get(i).getPergunta());                        
                        System.out.println(quiz.getPerguntas().get(i).getRespostas());
                        inputAnswer = inputQuiz.nextInt();
                        
                        //VERIFICA SE A RESPOSTA ESTA, CASO ESTEJA CERTA, ADD 10.00 AO SALDO DO PARTICIPANTE
                        if(inputAnswer == quiz.getPerguntas().get(i).getRespostaCerta()){
                            participante.addSaldo(10f);
                        }
                    }
                    
                    // SE PARTICIPANTE DIFERENTE DE NULL ADD PARTICIPANTE AO QUIZ
                    if (participante != null) {
                        quiz.addParticipante(participante);
                    }
                     System.out.println(" ----- FIM - OBRIGADO POR PARTICIPAR DO NOSSO QUIZ-------");
                    
                    break;
                case 2: // MOSTRAR RANKING

                    System.out.println(" ----- RANKING -------");
                    System.out.println(" NOME ---- CPF ----- SALDO");
                    
                    // ORDENA A LISTA
                    Collections.sort(quiz.getParticipantes());
                    for (int i = 0; i < quiz.getParticipantes().size(); i++) {
                        
                        System.out.println((i+1)+" - "+quiz.getParticipantes().get(i).getNome() + " - " + quiz.getParticipantes().get(i).getCpf()+ " - " + String.valueOf(quiz.getParticipantes().get(i).getSaldo()));
                    }
                    System.out.println(" ----- RANKING -------");
                break;
                default: // CASO NAO MUDE O STATUS DO CONTROLADOR DO QUIZ FINALIZA
                    System.out.println(" ----- OBRIGADO POR PARTICIPAR DO QUIZ -------");    
                break;
            }

        } while (controleQuiz != 0);

    }

    
    // METODO QUE CRIA AS PERGUNTAS DO QUIZ
    private static ArrayList<Pergunta> getListaPergunta() {
        
        // LISTA DE PERGUNTA
        ArrayList<Pergunta> listaPergunta = new ArrayList<>();
        
        // ADD PERGUNTAS E RESPOSTAS
        ArrayList<String> listaResposta1 = new ArrayList<>();
        Pergunta pergunta1 = new Pergunta();
        pergunta1.setRespostaCerta(3);
        pergunta1.setPergunta("1. É preciso preservar a fauna para manter a sustentabilidade do mundo equilibrada.  Protegendo a fauna brasileira, quais tipos de espécies são protegidas?");
        listaResposta1.add("1 - Espécies invertebradas");
        listaResposta1.add("2 - Espécies vertebradas");
        listaResposta1.add("3 - Espécies invertebradas e vertebradas");
        listaResposta1.add("4 - Nenhuma das alternativas");
        
        pergunta1.setRespostas(listaResposta1);
        listaPergunta.add(pergunta1);
        
        
        ArrayList<String> listaResposta2 = new ArrayList<>();
        Pergunta pergunta2 = new Pergunta();
        pergunta2.setRespostaCerta(2);
        pergunta2.setPergunta("2. Qual dos animais abaixo já foi extinto");
        listaResposta2.add("1 - Jaguatirica");
        listaResposta2.add("2 - Arara-Azul");
        listaResposta2.add("3 - Onça Pintada");
        listaResposta2.add("4 - Nenhum dos animais acima.");
        pergunta2.setRespostas(listaResposta2);
        
        listaPergunta.add(pergunta2);
        
        
        ArrayList<String> listaResposta3 = new ArrayList<>();
        Pergunta pergunta3 = new Pergunta();
        pergunta3.setRespostaCerta(1);
        pergunta3.setPergunta("3. Atualmente no Brasil algumas espécies de animais sofrem extinção. Qual é destes animais abaixo um dos que estão ameaçados de extinção?");
        listaResposta3.add("1 - Mico-Leão-Dourado");
        listaResposta3.add("2 - Uacari");
        listaResposta3.add("3 - Baleia Jubarte");
        listaResposta3.add("4 - Nenhum dos animais acima.");
        pergunta3.setRespostas(listaResposta3);
        
        listaPergunta.add(pergunta3);
        
        
        ArrayList<String> listaResposta4 = new ArrayList<>();
        Pergunta pergunta4 = new Pergunta();
        pergunta4.setRespostaCerta(3);
        pergunta4.setPergunta("4. Qual dos animais abaixo corre o maior risco de extinção no mundo?");
        listaResposta4.add("1 - Cavalo-Marinho");
        listaResposta4.add("2 - Girafa");
        listaResposta4.add("3 - Rinoceronte-branco-do-norte");
        listaResposta4.add("4 - Hipopótamo");
        pergunta4.setRespostas(listaResposta4);
        
        listaPergunta.add(pergunta4);
        
        
        ArrayList<String> listaResposta5 = new ArrayList<>();
        Pergunta pergunta5 = new Pergunta();
        pergunta5.setRespostaCerta(4);
        pergunta5.setPergunta("5. Quais desses fatores fazem parte das causas que podem levar uma espécie de animal a correr risco de extinção?");
        listaResposta5.add("1 - Fortes chuvas");
        listaResposta5.add("2 - Agricultura");
        listaResposta5.add("3 - Rede elétrica");
        listaResposta5.add("4 - Poluição");
        pergunta5.setRespostas(listaResposta5);
       
        listaPergunta.add(pergunta5);
        
        
        
        
        ArrayList<String> listaResposta6 = new ArrayList<>();
        Pergunta pergunta6 = new Pergunta();
        pergunta6.setRespostaCerta(4);
        pergunta6.setPergunta("6. Quais desses biomas não fazem parte do Brasil?");
        listaResposta6.add("1 - Caatinga");
        listaResposta6.add("2 - Pampas");
        listaResposta6.add("3 - Pantanal");
        listaResposta6.add("4 - Tundra ");
        pergunta6.setRespostas(listaResposta6);
        
        listaPergunta.add(pergunta6);
        
        
        ArrayList<String> listaResposta7 = new ArrayList<>();
        Pergunta pergunta7 = new Pergunta();
        pergunta7.setRespostaCerta(2);
        pergunta7.setPergunta("7. Qual é o número estimado de animais que existem no Brasil?");
        listaResposta7.add("1 - 31 mil");
        listaResposta7.add("2 - 106 mil");
        listaResposta7.add("3 - 300 mil");
        listaResposta7.add("4 - 6 mil");
        pergunta7.setRespostas(listaResposta7);
        
        listaPergunta.add(pergunta7);
        
        
        ArrayList<String> listaResposta8 = new ArrayList<>();
        Pergunta pergunta8 = new Pergunta();
        pergunta8.setRespostaCerta(2);
        pergunta8.setPergunta("8. O governo disponibiliza um livro online que lista todas as espécies de animais que correm risco de extinção, qual é o nome desse livro?");
        listaResposta8.add("1 - Livro dos Animais em Extinção");
        listaResposta8.add("2 - Livro Vermelho da Fauna Brasileira");
        listaResposta8.add("3 - Lista Negra dos Animais");
        listaResposta8.add("4 - Livro dos Animais");
        pergunta8.setRespostas(listaResposta8);
        
        listaPergunta.add(pergunta8);
        
        
        ArrayList<String> listaResposta9 = new ArrayList<>();
        Pergunta pergunta9 = new Pergunta();
        pergunta9.setRespostaCerta(1);
        pergunta9.setPergunta("9. Quais são as maiores vítimas do tráfico de animais?");
        listaResposta9.add("1 - As aves, pois são muito procuradas por sua beleza");
        listaResposta9.add("2 - As baleias, acabam crescendo muito e são abandonadas pelos seus donos");
        listaResposta9.add("3 - Os lagartos, pois eles não conseguem se adaptar a vida em cativeiro");
        listaResposta9.add("4 - Os roedores, pois sua alimentação adequada só é encontrada na floresta");
        pergunta9.setRespostas(listaResposta9);
        
        listaPergunta.add(pergunta9);
        
        
        ArrayList<String> listaResposta10 = new ArrayList<>();
        Pergunta pergunta10 = new Pergunta();
        pergunta10.setRespostaCerta(2);
        pergunta10.setPergunta("10. Onde geralmente são vendidos os animais silvestres vítimas do tráfico?");
        listaResposta10.add("1 - Nos sites de e-comércio");
        listaResposta10.add("2 - Feiras livres");
        listaResposta10.add("3 - Rodoviárias");
        listaResposta10.add("4 - Ibama");
        pergunta10.setRespostas(listaResposta10);
        
        listaPergunta.add(pergunta10);
        
        
        
        return listaPergunta;
    }
}
