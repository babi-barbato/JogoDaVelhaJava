package org.example;
import java.util.ArrayList;
import java.util.List;

public class Jogo {
    //Atributos
    private List<Jogador> jogadores;
    private List<Integer> nums;
    private String vez;
    private List<Integer> vezJogador;

    //Construtor
    public Jogo() {
        this.jogadores = new ArrayList<>();
        this.nums = new ArrayList<>();
        this.vez = "O";
        this.vezJogador = new ArrayList<>();
    }

    //Metodos
    public void adicionarJogador(Jogador j){
        if(jogadores.size() < 2){
            if (jogadores.size() == 0){
                jogadores.add(j);
                System.out.println("Jogador 1 adicionado com sucesso! Você será\u001B[31m 'O' \u001B[0m");
            }else {
                jogadores.add(j);
                System.out.println("Jogador 2 adicionado com sucesso! Você será\u001B[32m 'X' \u001B[0m");
            }
        }else{
            System.out.println("Já tem dois jogadores adicionados nesse jogo!");
            System.out.println("São Eles: " + jogadores.get(0) + " e " + jogadores.get(1));
        }
    }

    public void escolherPosicao(int jogada, int jogador){
        if (jogada <= 9 && jogada >= 1){

            if(nums.contains(jogada)){
                System.out.println("Você ou seu rival já esolheram esse número! Escolha outro");
            }else {
                nums.add(jogada);
                if(vez.equals("O")){
                    vezJogador.add(jogador);
                    jogadores.get(0).adicionarJogada(jogada);
                    vez = "X";
                }else{
                    vezJogador.add(jogador);
                    jogadores.get(1).adicionarJogada(jogada);
                    vez = "O";
                }
            }

        }else {
            System.out.println("Escolha um número que vá de 1 á 9 ( como no quadrante )");
        }
        jogoVisual();
    }

    public void ver(){
        System.out.println(vezJogador);
    }

    public void jogoVisual(){
        String n1 = " 1 ";
        String n2 = " 2 ";
        String n3 = " 3 ";
        String n4 = " 4 ";
        String n5 = " 5 ";
        String n6 = " 6 ";
        String n7 = " 7 ";
        String n8 = " 8 ";
        String n9 = " 9 ";

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i); //pega a posição escolhida

            String desenho = (vezJogador.get(i) == 0) ? "\u001B[31m O \u001B[0m" : "\u001B[32m X \u001B[0m"; //verifica se é o jogador 1 ou 2

            switch (num) {
                case 1:
                    n1 = desenho;
                    break;
                case 2:
                    n2 = desenho;
                    break;
                case 3:
                    n3 = desenho;
                    break;
                case 4:
                    n4 = desenho;
                    break;
                case 5:
                    n5 = desenho;
                    break;
                case 6:
                    n6 = desenho;
                    break;
                case 7:
                    n7 = desenho;
                    break;
                case 8:
                    n8 = desenho;
                    break;
                case 9:
                    n9 = desenho;
                    break;
            }
        }

        //Mostra o tabuleiro no terminal
        System.out.printf("""
                %s|%s|%s
                ===|===|===
                %s|%s|%s
                ===|===|===
                %s|%s|%s
                \n""", n1,n2,n3,n4,n5,n6,n7,n8,n9);
    }

    public boolean vencer(){
        List<List<Integer>> solucoes = new ArrayList<>();
        boolean venceu = false;

        // Adicionar as solucoes possiveis
        solucoes.add(List.of(1, 2, 3));
        solucoes.add(List.of(4, 5, 6));
        solucoes.add(List.of(7, 8, 9));

        solucoes.add(List.of(1, 4, 7));
        solucoes.add(List.of(2, 5, 8));
        solucoes.add(List.of(3, 6, 9));

        solucoes.add(List.of(1, 5, 9));
        solucoes.add(List.of(3, 5, 7));

        selectionSort(jogadores.get(0).getListaJogadas());
        selectionSort(jogadores.get(1).getListaJogadas());

        for (List<Integer> solucao : solucoes) {
            if(jogadores.get(0).getListaJogadas().containsAll(solucao)){
                venceu = true;
            }
        }

        if(venceu){
            System.out.println("Jogador "+jogadores.get(0).getNome()+" Venceu \uD83C\uDFC6");
            return true;
        }

        for (List<Integer> solucao : solucoes) {
            if(jogadores.get(1).getListaJogadas().containsAll(solucao)){
                venceu = true;
            }
        }

        if(venceu){
            System.out.println("Jogador "+jogadores.get(1).getNome()+" venceu \uD83C\uDFC6");
            return true;
        }

        if(vezJogador.size() == 9){
            System.out.println("O jogo deu velha! \uD83E\uDD1D");
            return true;
        }

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return false;
    }

    public void quadrante(){
        System.out.println("""
                 1 | 2 | 3
                ===|===|===
                 4 | 5 | 6
                ===|===|===
                 7 | 8 | 9
                """);
    }

    public void selectionSort(List<Integer> lista) {
        int n = lista.size();

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                if (lista.get(j) < lista.get(indiceMinimo)) {
                    indiceMinimo = j;
                }
            }

            // Trocar o elemento mínimo encontrado com o primeiro não ordenado
            int temp = lista.get(i);
            lista.set(i, lista.get(indiceMinimo));
            lista.set(indiceMinimo, temp);
        }
    }
}
