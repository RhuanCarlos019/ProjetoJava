package com.example.footballclub.controllers;

import com.example.footballclub.models.Clube;
import com.example.footballclub.service.ClubeServico;
import com.example.footballclub.views.ClubeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClubeControle {
    private ClubeViewJava clubeView;
    private ClubeServico clubeServico;

    public ClubeControle(ClubeViewJava clubeView, ClubeServico clubeServico) {
        this.clubeView = clubeView;
        this.clubeServico = clubeServico;
        initControle();
    }

    private void initControle() {
        clubeView.getBtnAdicionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarClube();
            }
        });

        clubeView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarClubes();
            }
        });

        clubeView.getBtnAtualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarClube();
            }
        });

        clubeView.getBtnRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerClube();
            }
        });
    }

    private void adicionarClube() {
        String nome = clubeView.getTxtNome().getText();
        String categoria = clubeView.getTxtCategoria().getText();
        String usuario = "someUser"; // Altere para obter o usuário corretamente

        Clube clube = new Clube(nome, categoria, usuario);
        clubeServico.adicionarClube(clube);
        listarClubes();
        clubeView.limparCampos();
    }

    private void listarClubes() {
        List<Clube> clubes = clubeServico.listarClubes();
        clubeView.atualizarTabelaClubes(clubes);
    }

    private void atualizarClube() {
        int id = Integer.parseInt(clubeView.getTxtId().getText());
        String nome = clubeView.getTxtNome().getText();
        String categoria = clubeView.getTxtCategoria().getText();
        String usuario = "someUser"; // Altere para obter o usuário corretamente

        Clube clube = new Clube(id, nome, categoria, usuario);
        clubeServico.atualizarClube(clube);
        listarClubes();
        clubeView.limparCampos();
    }

    private void removerClube() {
        int id = Integer.parseInt(clubeView.getTxtId().getText());
        clubeServico.removerClube(id);
        listarClubes();
        clubeView.limparCampos();
    }
}
