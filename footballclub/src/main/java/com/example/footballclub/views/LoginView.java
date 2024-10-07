package com.example.footballclub.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtNome;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private JButton btnRegistrar;

    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação dos componentes
        txtNome = new JTextField(20);
        txtEmail = new JTextField(20);
        txtSenha = new JPasswordField(20);
        btnLogin = new JButton("Login");
        btnRegistrar = new JButton("Registrar");

        // Layout
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Senha:"));
        add(txtSenha);
        add(btnLogin);
        add(btnRegistrar);
    }

    // Métodos para obter os componentes
    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }
}
