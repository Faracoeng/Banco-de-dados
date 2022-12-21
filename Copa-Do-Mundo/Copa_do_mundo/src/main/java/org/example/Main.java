package org.example;

import controllers.DbCartãoDAO;
import controllers.DbGolDAO;
import controllers.DbJogadorDAO;
import entities.Cartao;
import entities.Gol;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{


        DbGolDAO dbGolDAO = new DbGolDAO();
        DbJogadorDAO dbJogadorDAO = new DbJogadorDAO();
        DbCartãoDAO dbCartãoDAO = new DbCartãoDAO();

        Gol gol;
        Cartao cartao;

        Scanner menu = new Scanner (System.in);
        imprime_menu();
        int opcao = menu.nextInt();
        while (opcao != 5){

        switch (opcao) {
            case 1:
                System.out.println("Digite 1 para registrar um Gol, ou 2 para registrar um Cartão");
                int evento = menu.nextInt();

                if (evento == 1) {

                    System.out.println("Informe o id do Jogador");
                    int Jogador_idJogador = menu.nextInt();
                    System.out.println("Informe o id da Partida");
                    int Partida_idPartida = menu.nextInt();
                    System.out.println("Informe o horario da partida em minutos inteiros");
                    int horario = menu.nextInt();
                    System.out.println("Informe o ano da edição da Copa");
                    int ano = menu.nextInt();

                    gol = new Gol(Jogador_idJogador, Partida_idPartida, horario, ano);

                    dbGolDAO.insert(gol);
                }
                else if (evento == 2){
                    System.out.println("Informe o id do Jogador");
                    int Jogador_idJogador = menu.nextInt();
                    System.out.println("Digite 1 para cartao AMARELO OU 2 para VERMELHO");
                    int Cor_idCor = menu.nextInt();
                    System.out.println("Informe o id da Partida");
                    int Partida_idPartida = menu.nextInt();

                    cartao = new Cartao(Jogador_idJogador, Cor_idCor, Partida_idPartida);

                    dbCartãoDAO.insert(cartao);

                }else System.out.println("Opcao invalida");
                break;

            case 2:
                System.out.print("\nListar nome e país de todos os atacantes, de todos os times, de uma copa\n");
                System.out.println("Qual o ano da copa? (populados na base: [1958,1962,1970,2022])");
                int anoCopa = menu.nextInt();
                System.out.println("voce escolheu  edicao: " + anoCopa);


                ArrayList<String> lista_atacantes = new ArrayList<>();
                lista_atacantes = (ArrayList<String>) dbJogadorDAO.get_atacantes(anoCopa);

                for (String i : lista_atacantes){
                    System.out.println(i);
                }

                break;

            case 3:
                System.out.print("\nListar o total de gols de todos os atacantes de todas as seleções do Brasil\n");


                ArrayList<String> lista = new ArrayList<>();
                lista = (ArrayList<String>) dbGolDAO.getGolsBrasileiros();

                for (String i : lista){
                    System.out.println(i);
                }
                break;

            default:
                System.out.print("\nOpção Inválida!");
                break;

            case 4:
                System.out.print("\nO nome do maior goleador: ");
                System.out.println(dbGolDAO.getArtilheiro());


        }
            imprime_menu();
            opcao = menu.nextInt();
    }
        System.out.println("Até logo");
    }

    private static void imprime_menu() {
        System.out.print("|-----------------------------------------------------------------------------------------------------------|\n");
        System.out.print("| Opção 1 - Adicionar eventos que ocorreram em uma partida                                                  |\n");
        System.out.print("| Opção 2 - Listar nome e país de todos os atacantes, de todos os times, de uma copa                        |\n");
        System.out.print("| Opção 3 - Listar o total de gols de todos os atacantes de todas as seleções do Brasil                     |\n");
        System.out.print("| Opção 4 - Listar o nome do jogador que foi o maior goleador de todos as copas                             |\n");
        System.out.print("| Opção 5 - Sair                                                                                            |\n");
        System.out.print("|-----------------------------------------------------------------------------------------------------------|\n");
        System.out.print("Digite uma opção: ");
    }
}