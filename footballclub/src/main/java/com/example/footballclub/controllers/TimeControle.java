package com.example.footballclub.controllers;

import com.example.footballclub.models.Time;
import com.example.footballclub.repository.TimeRepositorio;
import com.example.footballclub.service.TimeServico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TimeControle {
    private TimeServico timeServico;
    private Scanner scanner;

    public TimeControle(Connection connection) {
        // Criar o repositório e o serviço com a conexão
        TimeRepositorio timeRepositorio = new TimeRepositorio(connection);
        this.timeServico = new TimeServico(timeRepositorio);
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir o menu de time
    public void menuTime() throws SQLException {
        int opcao;
        do {
            System.out.println("Menu Time:");
            System.out.println("1. Adicionar Time");
            System.out.println("2. Listar Times");
            System.out.println("3. Atualizar Time");
            System.out.println("4. Remover Time");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarTime();
                    break;
                case 2:
                    listarTimes();
                    break;
                case 3:
                    atualizarTime();
                    break;
                case 4:
                    removerTime();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // Método para adicionar um time
    private void adicionarTime() throws SQLException {
        System.out.print("Nome do time: ");
        String nome = scanner.next();
        System.out.print("Categoria do time: ");
        String categoria = scanner.next();

        Time time = new Time(0, nome, categoria); // Ajuste o ID
        timeServico.adicionarTime(time);
        System.out.println("Time adicionado com sucesso!");
    }

    // Método para listar todos os times
    private void listarTimes() throws SQLException {
        List<Time> times = timeServico.listarTimes();
        System.out.println("Lista de Times:");
        for (Time time : times) {
            System.out.println(time.getNome());
        }
    }

    // Método para atualizar um time
    private void atualizarTime() throws SQLException {
        System.out.print("ID do time a ser atualizado: ");
        int id = scanner.nextInt();
        
        System.out.print("Novo nome do time: ");
        String nome = scanner.next();
        System.out.print("Nova categoria do time: ");
        String categoria = scanner.next();

        Time time = new Time(id, nome, categoria); // Ajuste o ID
        timeServico.atualizarTime(time);
        System.out.println("Time atualizado com sucesso!");
    }

    // Método para remover um time
    private void removerTime() throws SQLException {
        System.out.print("ID do time a ser removido: ");
        int id = scanner.nextInt();
        timeServico.removerTime(id);
        System.out.println("Time removido com sucesso!");
    }
}
