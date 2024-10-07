package com.example.footballclub.repository;

import com.example.footballclub.models.Time;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeRepositorio {
    private final Connection connection;

    public TimeRepositorio(Connection connection) {
        this.connection = connection;
    }

    public void adicionarTime(Time time) throws SQLException {
        String sql = "INSERT INTO times (nome, categoria) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, time.getNome());
            statement.setString(2, time.getCategoria());
            statement.executeUpdate();
        }
    }

    public List<Time> listarTimes() throws SQLException {
        List<Time> times = new ArrayList<>();
        String sql = "SELECT * FROM times";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String categoria = resultSet.getString("categoria");
                times.add(new Time(id, nome, categoria));
            }
        }
        return times;
    }

    public void atualizarTime(Time time) throws SQLException {
        String sql = "UPDATE times SET nome = ?, categoria = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, time.getNome());
            statement.setString(2, time.getCategoria());
            statement.setInt(3, time.getId());
            statement.executeUpdate();
        }
    }

    public void removerTime(int id) throws SQLException {
        String sql = "DELETE FROM times WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
