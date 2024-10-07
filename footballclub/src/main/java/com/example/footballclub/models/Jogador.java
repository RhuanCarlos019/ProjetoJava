package com.example.footballclub.models;

public class Jogador {
    private int id;
    private String nome;
    private int idade;
    private String posicao;
    private Clube clube;  // Associação com o Clube

    // Construtor com Clube
    public Jogador(int id, String nome, int idade, String posicao, Clube clube) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.clube = clube;
    }

    // Construtor sem ID (para novo jogador sem ID)
    public Jogador(String nome, int idade, String posicao, Clube clube) {
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.clube = clube;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public Clube getClube() {
        return clube;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }
}
