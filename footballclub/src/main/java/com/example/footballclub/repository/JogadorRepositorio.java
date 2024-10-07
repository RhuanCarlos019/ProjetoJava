package com.example.footballclub.repository;

import com.example.footballclub.models.Jogador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogadorRepositorio {
    private final Connection connection;

    public JogadorRepositorio(Connection connection) {
        this.connection = connection;
    }

    public void adicionarJogador(Jogador jogador) throws SQLException {
        String sql = "INSERT INTO jogadores (nome, idade, posicao, id_clube) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jogador.getNome());
            statement.setInt(2, jogador.getIdade());
            statement.setString(3, jogador.getPosicao());
            statement.setInt(4, jogador.getClube().getId());
            statement.executeUpdate();
        }
    }

    public List<Jogador> listarJogadores() throws SQLException {
        List<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM jogadores";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                String posicao = resultSet.getString("posicao");
                jogadores.add(new Jogador(id, nome, idade, posicao, null)); // Ajuste com o time
            }
        }
        return jogadores;
    }

    public void atualizarJogador(Jogador jogador) throws SQLException {
        String sql = "UPDATE jogadores SET nome = ?, idade = ?, posicao = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jogador.getNome());
            statement.setInt(2, jogador.getIdade());
            statement.setString(3, jogador.getPosicao());
            statement.setInt(4, jogador.getId());
            statement.executeUpdate();
        }
    }

    public void removerJogador(int id) throws SQLException {
        String sql = "DELETE FROM jogadores WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
