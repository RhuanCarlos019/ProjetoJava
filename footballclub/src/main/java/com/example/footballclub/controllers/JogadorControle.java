package com.example.footballclub.controllers;

import com.example.footballclub.models.Jogador;
import com.example.footballclub.service.JogadorServico;
import com.example.footballclub.views.JogadorView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class JogadorControle {
    private final JogadorServico jogadorServico;
    private final JogadorView jogadorView;

    public JogadorControle(JogadorServico jogadorServico, JogadorView jogadorView) {
        this.jogadorServico = jogadorServico;
        this.jogadorView = jogadorView;

        configurarEventos();
    }

    private void configurarEventos() {
        jogadorView.getBtnAdicionar().addActionListener(e -> adicionarJogador());
        jogadorView.getBtnListar().addActionListener(e -> listarJogadores());
        jogadorView.getBtnAtualizar().addActionListener(e -> atualizarJogador());
        jogadorView.getBtnRemover().addActionListener(e -> removerJogador());
    }

    private void adicionarJogador() {
        String nome = jogadorView.getTxtNome().getText();
        int idade = Integer.parseInt(jogadorView.getTxtIdade().getText());
        String posicao = jogadorView.getTxtPosicao().getText();

        Jogador jogador = new Jogador(nome, idade, posicao, null); // Ajuste para time
        try {
            jogadorServico.adicionarJogador(jogador);
            JOptionPane.showMessageDialog(jogadorView, "Jogador adicionado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jogadorView, "Erro ao adicionar jogador: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarJogadores() {
        try {
            List<Jogador> jogadores = jogadorServico.listarJogadores();
            jogadorView.atualizarTabelaJogadores(jogadores);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jogadorView, "Erro ao listar jogadores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarJogador() {
        try {
            int id = Integer.parseInt(jogadorView.getTxtId().getText());
            String nome = jogadorView.getTxtNome().getText();
            int idade = Integer.parseInt(jogadorView.getTxtIdade().getText());
            String posicao = jogadorView.getTxtPosicao().getText();

            Jogador jogador = new Jogador(id, nome, idade, posicao, null); // Ajuste para time
            jogadorServico.atualizarJogador(jogador);
            JOptionPane.showMessageDialog(jogadorView, "Jogador atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jogadorView, "Erro ao atualizar jogador: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerJogador() {
        try {
            int id = Integer.parseInt(jogadorView.getTxtId().getText());
            jogadorServico.removerJogador(id);
            JOptionPane.showMessageDialog(jogadorView, "Jogador removido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jogadorView, "Erro ao remover jogador: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
