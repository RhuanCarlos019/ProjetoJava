package com.example.footballclub.service;

import com.example.footballclub.models.Clube;
import com.example.footballclub.repository.ClubeRepositorio;

import java.sql.SQLException;
import java.util.List;

public class ClubeServico {
    private ClubeRepositorio clubeRepositorio;

    public ClubeServico(ClubeRepositorio clubeRepositorio) {
        this.clubeRepositorio = clubeRepositorio;
    }

    public void adicionarClube(Clube clube) throws SQLException {
        clubeRepositorio.adicionarClube(clube);
    }

    public List<Clube> listarClubes(String usuario) throws SQLException {
        return clubeRepositorio.listarClubes(usuario);
    }

    public void atualizarClube(Clube clube) throws SQLException {
        clubeRepositorio.atualizarClube(clube);
    }

    public void removerClube(int id) throws SQLException {
        clubeRepositorio.removerClube(id);
    }
}
