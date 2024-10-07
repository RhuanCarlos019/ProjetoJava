package com.example.footballclub.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroView extends JFrame {
    private JTextField nomeField;
    private JPasswordField senhaField;
    private JButton cadastrarButton;

    public CadastroView() {
        setTitle("Cadastro");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 80, 25);
        panel.add(nomeLabel);

        nomeField = new JTextField(20);
        nomeField.setBounds(100, 20, 165, 25);
        panel.add(nomeField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(10, 50, 80, 25);
        panel.add(senhaLabel);

        senhaField = new JPasswordField(20);
        senhaField.setBounds(100, 50, 165, 25);
        panel.add(senhaField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(10, 80, 150, 25);
        panel.add(cadastrarButton);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public String getSenha() {
        return new String(senhaField.getPassword());
    }

    public void addCadastrarListener(ActionListener listener) {
        cadastrarButton.addActionListener(listener);
    }
}
