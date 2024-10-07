package com.example;

import javax.swing.*;

import com.example.footballclub.views.ClubeView;
import com.example.footballclub.views.JogadorView;

import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Futebol Clube");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Configuração do layout
        setLayout(new BorderLayout());

        // Adicionando um painel com um título
        JLabel titleLabel = new JLabel("Bem-vindo ao Sistema de Gestão de Futebol Clube!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // Botão para abrir o menu de clubes
        JButton clubesButton = new JButton("Gerenciar Clubes");
        clubesButton.addActionListener(e -> abrirClubeView());
        add(clubesButton, BorderLayout.CENTER);
        
        // Botão para abrir o menu de jogadores
        JButton jogadoresButton = new JButton("Gerenciar Jogadores");
        jogadoresButton.addActionListener(e -> abrirJogadorView());
        add(jogadoresButton, BorderLayout.SOUTH);
    }

    private void abrirClubeView() {
        // Aqui você pode instanciar a ClubeView e exibi-la
        ClubeView clubeView = new ClubeView();
        clubeView.setVisible(true);
    }

    private void abrirJogadorView() {
        // Aqui você pode instanciar a JogadorView e exibi-la
        JogadorView jogadorView = new JogadorView();
        jogadorView.setVisible(true);
    }
}
