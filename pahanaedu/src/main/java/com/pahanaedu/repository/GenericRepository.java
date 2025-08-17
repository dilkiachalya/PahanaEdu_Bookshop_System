package com.pahanaedu.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T> {
    void add(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(String id) throws SQLException;
    T getById(String id) throws SQLException;
    List<T> getAll() throws SQLException;
}
