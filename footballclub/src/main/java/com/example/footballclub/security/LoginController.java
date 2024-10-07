package com.example.footballclub.security;

import com.example.footballclub.models.Clube;
import com.example.footballclub.security.Autenticacao;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {

    private Autenticacao autenticacao;

    public LoginController(Connection connection) {
        this.autenticacao = new Autenticacao(connection);
    }

    // Método que gerencia a requisição de login
    public String login(String email, String senha) {
        try {
            Clube clubeAutenticado = autenticacao.autenticarClube(email, senha);
            if (clubeAutenticado != null) {
                // Se o clube for autenticado, retorna uma mensagem de sucesso
                return "Login bem-sucedido! Bem-vindo, " + clubeAutenticado.getNome() + "!";
            } else {
                // Se as credenciais estiverem incorretas, retorna uma mensagem de erro
                return "Erro: Email ou senha inválidos.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao tentar realizar o login. Por favor, tente novamente.";
        }
    }
}
