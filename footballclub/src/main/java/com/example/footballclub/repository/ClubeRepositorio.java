package com.example.footballclub.repository;

import com.example.footballclub.models.Clube;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClubeRepositorio {
    private Connection connection;

    public ClubeRepositorio(Connection connection) {
        this.connection = connection;
    }

    public void adicionarClube(Clube clube) throws SQLException {
        String sql = "INSERT INTO clubes (nome, categoria, usuario) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clube.getNome());
            statement.setString(2, clube.getCategoria());
            statement.setString(3, clube.getUsuario());
            statement.executeUpdate();
        }
    }

    public List<Clube> listarClubes(String usuario) throws SQLException {
        List<Clube> clubes = new ArrayList<>();
        String sql = "SELECT * FROM clubes WHERE usuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String categoria = resultSet.getString("categoria");
                String usuarioClube = resultSet.getString("usuario");
                clubes.add(new Clube(id, nome, categoria, usuarioClube)); // Usando o construtor correto
            }
        }
        return clubes;
    }

    public void atualizarClube(Clube clube) throws SQLException {
        String sql = "UPDATE clubes SET nome = ?, categoria = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clube.getNome());
            statement.setString(2, clube.getCategoria());
            statement.setInt(3, clube.getId());
            statement.executeUpdate();
        }
    }

    public void removerClube(int id) throws SQLException {
        String sql = "DELETE FROM clubes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
