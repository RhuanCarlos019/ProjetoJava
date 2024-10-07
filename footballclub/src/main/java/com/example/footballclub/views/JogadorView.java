package com.example.footballclub.views;

import com.example.footballclub.models.Jogador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;  // Importação necessária
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class JogadorView extends JFrame {
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtPosicao;
    private JButton btnAdicionar;
    private JButton btnListar;
    private JButton btnAtualizar;
    private JButton btnRemover;
    private JTable tabelaJogadores;
    private DefaultTableModel tabelaModel;

    public JogadorView() {
        setTitle("Gerenciamento de Jogadores");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de entrada
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(5, 2));

        painelEntrada.add(new JLabel("ID:"));
        txtId = new JTextField();
        painelEntrada.add(txtId);

        painelEntrada.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelEntrada.add(txtNome);

        painelEntrada.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelEntrada.add(txtIdade);

        painelEntrada.add(new JLabel("Posição:"));
        txtPosicao = new JTextField();
        painelEntrada.add(txtPosicao);

        btnAdicionar = new JButton("Adicionar");
        painelEntrada.add(btnAdicionar);
        btnListar = new JButton("Listar");
        painelEntrada.add(btnListar);
        btnAtualizar = new JButton("Atualizar");
        painelEntrada.add(btnAtualizar);
        btnRemover = new JButton("Remover");
        painelEntrada.add(btnRemover);

        add(painelEntrada, BorderLayout.NORTH);

        // Tabela de jogadores
        tabelaModel = new DefaultTableModel(new String[]{"ID", "Nome", "Idade", "Posição"}, 0);
        tabelaJogadores = new JTable(tabelaModel);
        add(new JScrollPane(tabelaJogadores), BorderLayout.CENTER);
    }

    // Métodos para obter os campos e botões
    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtIdade() {
        return txtIdade;
    }

    public JTextField getTxtPosicao() {
        return txtPosicao;
    }

    public JButton getBtnAdicionar() {
        return btnAdicionar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public JButton getBtnRemover() {
        return btnRemover;
    }

    // Método para atualizar a tabela com a lista de jogadores
    public void atualizarTabelaJogadores(List<Jogador> jogadores) {
        tabelaModel.setRowCount(0); // Limpa a tabela
        for (Jogador jogador : jogadores) {
            tabelaModel.addRow(new Object[]{jogador.getId(), jogador.getNome(), jogador.getIdade(), jogador.getPosicao()});
        }
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
