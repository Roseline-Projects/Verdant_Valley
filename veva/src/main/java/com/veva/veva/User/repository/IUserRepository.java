package com.veva.veva.User.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.veva.veva.User.model.User;

public interface IUserRepository extends DAO<User> { //this doesn't seem correct

    List<User> getAll();

    boolean save(User user);

    Optional<User> getById(int userId);

    boolean updateById(User user, int userId);

    boolean deleteById(int userId);

}
