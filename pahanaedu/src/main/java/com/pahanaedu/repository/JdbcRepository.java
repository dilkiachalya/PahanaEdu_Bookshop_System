package com.pahanaedu.repository;

import com.pahanaedu.app.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class JdbcRepository {
    protected Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance().getConnection();
    }

    protected void close(AutoCloseable ac) {
        if (ac != null) {
            try { ac.close(); } catch (Exception ignored) {}
        }
    }
}
