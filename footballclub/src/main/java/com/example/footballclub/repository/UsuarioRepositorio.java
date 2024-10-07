package com.example.footballclub.repository;

import com.example.footballclub.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepositorio {
    private Connection connection;

    public UsuarioRepositorio(Connection connection) {
        this.connection = connection;
    }

    // Método para cadastrar um novo usuário
    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para realizar login de um usuário
    public Usuario login(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Cria e retorna um novo objeto Usuario se as credenciais forem válidas
                return new Usuario(resultSet.getInt("id"), 
                                   resultSet.getString("nome"), 
                                   resultSet.getString("email"), 
                                   resultSet.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se as credenciais forem inválidas
    }
}
