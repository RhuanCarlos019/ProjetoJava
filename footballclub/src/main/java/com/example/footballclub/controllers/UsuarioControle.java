package com.example.footballclub.controllers;

import com.example.footballclub.models.Usuario;
import com.example.footballclub.service.UsuarioServico;
import com.example.footballclub.views.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioControle {
    private LoginView loginView;
    private UsuarioServico usuarioServico;

    public UsuarioControle(LoginView loginView, UsuarioServico usuarioServico) {
        this.loginView = loginView;
        this.usuarioServico = usuarioServico;

        // Adicionar listeners
        loginView.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });

        loginView.getBtnRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarRegistro();
            }
        });
    }

    private void realizarLogin() {
        String email = loginView.getTxtEmail().getText();
        String senha = new String(loginView.getTxtSenha().getPassword());
        
        // Verifica se o usuário existe e realiza o login
        if (usuarioServico.login(email, senha)) {
            JOptionPane.showMessageDialog(loginView, "Login realizado com sucesso!");
            // Aqui você pode abrir a próxima tela, como a de gerenciamento do clube
        } else {
            JOptionPane.showMessageDialog(loginView, "Email ou senha incorretos. Tente novamente.");
        }
    }

    private void realizarRegistro() {
        String nome = loginView.getTxtNome().getText();
        String email = loginView.getTxtEmail().getText();
        String senha = new String(loginView.getTxtSenha().getPassword());

        // Cria um novo usuário e registra
        Usuario usuario = new Usuario(0, nome, email, senha); // O ID pode ser gerado no banco
        usuarioServico.cadastrarUsuario(usuario);
        JOptionPane.showMessageDialog(loginView, "Registro realizado com sucesso! Você pode fazer login agora.");
        
        // Limpa os campos após o registro
        loginView.getTxtNome().setText("");
        loginView.getTxtEmail().setText("");
        loginView.getTxtSenha().setText("");
    }
}
