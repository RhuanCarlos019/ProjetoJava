package com.example.footballclub.models;

public class Time {

    private int id;
    private String nome;
    private String categoria;

    // Construtor com todos os atributos
    public Time(int id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    // Construtor sem ID, para quando o time ainda não existe no banco
    public Time(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
