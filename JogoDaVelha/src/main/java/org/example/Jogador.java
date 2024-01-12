package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    //Atributos
    private String nome;
    private List<Integer> listaJogadas;

    //Getter e Setter

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integer> getListaJogadas() {
        return listaJogadas;
    }

    //Construtor
    public Jogador(String nome) {
        this.nome = nome;
        this.listaJogadas = new ArrayList<>();
    }

    //Metodos
    public void adicionarJogada(int i){
        listaJogadas.add(i);
    }
}
