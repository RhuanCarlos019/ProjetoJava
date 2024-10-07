package com.example.footballclub.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.footballclub.models.Clube;

public class Autenticacao {

    private Connection connection;

    public Autenticacao(Connection connection) {
        this.connection = connection;
    }

    // Método para autenticar um clube baseado em email e senha
    public Clube autenticarClube(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM clubes WHERE email = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, senha);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    // Retorna um objeto Clube se as credenciais estiverem corretas
                    return new Clube(id, nome, email);
                } else {
                    // Retorna null se as credenciais estiverem incorretas
                    return null;
                }
            }
        }
    }
}
