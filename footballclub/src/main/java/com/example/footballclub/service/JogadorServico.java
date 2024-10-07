package com.example.footballclub.service;

import com.example.footballclub.models.Jogador;
import com.example.footballclub.repository.JogadorRepositorio;

import java.sql.SQLException;
import java.util.List;

public class JogadorServico {
    private final JogadorRepositorio jogadorRepositorio;

    public JogadorServico(JogadorRepositorio jogadorRepositorio) {
        this.jogadorRepositorio = jogadorRepositorio;
    }

    public void adicionarJogador(Jogador jogador) throws SQLException {
        jogadorRepositorio.adicionarJogador(jogador);
    }

    public List<Jogador> listarJogadores() throws SQLException {
        return jogadorRepositorio.listarJogadores();
    }

    public void atualizarJogador(Jogador jogador) throws SQLException {
        jogadorRepositorio.atualizarJogador(jogador);
    }

    public void removerJogador(int id) throws SQLException {
        jogadorRepositorio.removerJogador(id);
    }
}
