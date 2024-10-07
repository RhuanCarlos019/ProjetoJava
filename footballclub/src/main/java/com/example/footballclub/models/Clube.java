package com.example.footballclub.models;

public class Clube {
    private int id;
    private String nome;
    private String categoria;
    private String usuario;

    // Construtor para criar um novo clube
    public Clube(String id2, String categoria, String usuario) {
        this.nome = id2;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    // Construtor para atualizar um clube existente
    public Clube(int id, String nome, String categoria, String usuario) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
