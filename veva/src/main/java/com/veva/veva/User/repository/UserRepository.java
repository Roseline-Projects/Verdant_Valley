package com.veva.veva.User.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.veva.veva.User.model.Origin;
import com.veva.veva.User.model.User;

public class UserRepository implements DAO<User> {

    private static final String getListSql = "SELECT user_id, username, email, password, origin from users";
    private static final String getItemSql = "SELECT user_id, username, email, password, origin from users where user_id = ?";
    private static final String saveItemSql = "insert into users(username, email, password, origin) values (?, ?, ?, ?)";
    private static final String updateItemSql = "update users set username = ?, email = ?, password = ?, origin = ? where user_id = ?";
    private static final String deleteItemSql = "delete from users where user_id = ?";

    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<User> rowMapper = (resultSet, rowNumber) -> {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setEmail(resultSet.getString("email"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        String originString = resultSet.getString("origin");

        //Arrays.stream(Origin.class.getEnumConstants()).filter(origin -> origin.toString().equals(originString)).toArray()[0];
        for(Origin o : Origin.class.getEnumConstants()) {
            if(o.toString().equals(originString)) {
                user.setOrigin(o);
                break;
            }
        }

        return user;
    };

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query(getItemSql, rowMapper);
    }

    @Override
    public boolean save(User user) {
        //user_id, username, email, password, origin
        int changes = jdbcTemplate.update(saveItemSql, user.getUserId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getOrigin());
        return changes == 1 ? true : false;
    }

    @Override
    public Optional<User> getById(int user_id) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(getItemSql, User.class, user_id);
        } catch (DataAccessException exp) {
            log.info("User with user id " + user_id + " not found");
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean updateById(User user, int user_id) {
        int changes = jdbcTemplate.update(updateItemSql, user.getUsername(), user.getEmail(), user.getPassword(), user.getOrigin(), user.getUserId());
        return changes == 1 ? true : false;
    }

    @Override
    public boolean deleteById(int user_id) {
        int changes = jdbcTemplate.update(deleteItemSql, user_id);
        return changes == 1 ? true : false;
    }    
}
