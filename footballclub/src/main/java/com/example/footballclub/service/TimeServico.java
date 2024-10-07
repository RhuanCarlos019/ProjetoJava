package com.example.footballclub.service;

import com.example.footballclub.models.Time;
import com.example.footballclub.repository.TimeRepositorio;

import java.sql.SQLException;
import java.util.List;

public class TimeServico {
    private final TimeRepositorio timeRepositorio;

    public TimeServico(TimeRepositorio timeRepositorio) {
        this.timeRepositorio = timeRepositorio;
    }

    public void adicionarTime(Time time) throws SQLException {
        timeRepositorio.adicionarTime(time);
    }

    public List<Time> listarTimes() throws SQLException {
        return timeRepositorio.listarTimes();
    }

    public void atualizarTime(Time time) throws SQLException {
        timeRepositorio.atualizarTime(time);
    }

    public void removerTime(int id) throws SQLException {
        timeRepositorio.removerTime(id);
    }
}
