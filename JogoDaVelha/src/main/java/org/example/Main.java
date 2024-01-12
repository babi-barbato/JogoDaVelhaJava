package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Jogo novoJogo = new Jogo();
        Scanner leitor = new Scanner(System.in);
        int vez = 0;

        System.out.println("""
        |            ██  ██████   ██████   ██████      ██████   █████      ██    ██ ███████ ██      ██   ██  █████ \s
        |            ██ ██    ██ ██       ██    ██     ██   ██ ██   ██     ██    ██ ██      ██      ██   ██ ██   ██ 
        |            ██ ██    ██ ██   ███ ██    ██     ██   ██ ███████     ██    ██ █████   ██      ███████ ███████ 
        |       ██   ██ ██    ██ ██    ██ ██    ██     ██   ██ ██   ██      ██  ██  ██      ██      ██   ██ ██   ██ 
        |        █████   ██████   ██████   ██████      ██████  ██   ██       ████   ███████ ███████ ██   ██ ██   ██ 
                                                                                                                 \s""");

        System.out.println("❚█══ Digite [S] para jogar ══█❚");
        String ler = leitor.next();

        System.out.printf("\nDigite o nome do 1° Jogador: ");
        String nome1 = leitor.next();
        Jogador j1 = new Jogador(nome1);
        novoJogo.adicionarJogador(j1);

        System.out.println();

        System.out.printf("Digite o nome do 2° Jogador: ");
        String nome2 = leitor.next();
        Jogador j2 = new Jogador(nome2);
        novoJogo.adicionarJogador(j2);

        System.out.println("\nPara escolher um número, basta seguir o modelo do quadrante a seguir:");
        novoJogo.quadrante();

        while (true){

            if(vez == 0){
                System.out.println("Escolha uma posição jogador "+ nome1 +":");
                int i = leitor.nextInt();
                novoJogo.escolherPosicao(i,vez);
                vez = 1;
            }else{
                System.out.println("Escolha uma posição jogador "+ nome2 + ":");
                int i = leitor.nextInt();
                novoJogo.escolherPosicao(i,vez);
                vez = 0;
            }
            boolean venceu = novoJogo.vencer();

            if(venceu){
                break;
            }

        }
    }
}