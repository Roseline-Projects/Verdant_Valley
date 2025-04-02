package com.veva.veva.User.repository;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> getAll();

    boolean save(T t);

    Optional<T> getById(int id);

    boolean updateById(T t, int id);

    boolean deleteById(int id);
}
