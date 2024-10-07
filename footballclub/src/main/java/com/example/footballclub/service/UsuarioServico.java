package com.example.footballclub.service;

import com.example.footballclub.models.Usuario;
import com.example.footballclub.repository.UsuarioRepositorio;

public class UsuarioServico {
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServico(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(Usuario usuario) {
        usuarioRepositorio.cadastrar(usuario);
    }

    // Método para realizar login de um usuário
    public boolean login(String email, String senha) {
        Usuario usuario = usuarioRepositorio.login(email, senha);
        return usuario != null; // Retorna true se o usuário existir, caso contrário, false
    }
}
