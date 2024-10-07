package com.example.connection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO {
    protected Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void close() throws SQLException;
}
