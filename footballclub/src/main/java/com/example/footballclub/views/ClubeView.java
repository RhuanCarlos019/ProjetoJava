package com.example.footballclub.views;

import com.example.footballclub.models.Clube;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;  // Importação necessária
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ClubeView extends JFrame {
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtCategoria;
    private JButton btnAdicionar;
    private JButton btnListar;
    private JButton btnAtualizar;
    private JButton btnRemover;
    private JTable tabelaClubes;
    private DefaultTableModel tabelaModel;

    public ClubeView() {
        setTitle("Gerenciamento de Clubes");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de entrada
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(4, 2));

        painelEntrada.add(new JLabel("ID:"));
        txtId = new JTextField();
        painelEntrada.add(txtId);

        painelEntrada.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelEntrada.add(txtNome);

        painelEntrada.add(new JLabel("Categoria:"));
        txtCategoria = new JTextField();
        painelEntrada.add(txtCategoria);

        btnAdicionar = new JButton("Adicionar");
        painelEntrada.add(btnAdicionar);
        btnListar = new JButton("Listar");
        painelEntrada.add(btnListar);
        btnAtualizar = new JButton("Atualizar");
        painelEntrada.add(btnAtualizar);
        btnRemover = new JButton("Remover");
        painelEntrada.add(btnRemover);

        add(painelEntrada, BorderLayout.NORTH);

        // Tabela de clubes
        tabelaModel = new DefaultTableModel(new String[]{"ID", "Nome", "Categoria"}, 0);
        tabelaClubes = new JTable(tabelaModel);
        add(new JScrollPane(tabelaClubes), BorderLayout.CENTER);
    }

    // Métodos para obter os campos e botões
    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtCategoria() {
        return txtCategoria;
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

    // Método para atualizar a tabela com a lista de clubes
    public void atualizarTabelaClubes(List<Clube> clubes) {
        tabelaModel.setRowCount(0); // Limpa a tabela
        for (Clube clube : clubes) {
            tabelaModel.addRow(new Object[]{clube.getId(), clube.getNome(), clube.getCategoria()});
        }
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
