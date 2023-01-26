package com.sudoku.sudokuapp.repository.impl;

import com.sudoku.sudokuapp.entity.User;
import com.sudoku.sudokuapp.entity.rowMapper.UserRowMapper;
import com.sudoku.sudokuapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(User user) {
        String sql = "Insert into users values(DEFAULT, ?, ?)";
        jdbcTemplate.update(sql,user.getLogin(), user.getPassword());
    }

    @Override
    public User getUserByCredentials(String login, String password) {
        String sql = "Select * from users where login = ? and password = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), login, password);
    }

    @Override
    public boolean existsUser(String login, String password) {
        String sql = "Select count(*) from users where login = ? and password = ?";
        if(jdbcTemplate.queryForObject(sql,Integer.class,login,password) == 0)
            return false;
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "Select * from users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public List<Integer> getListOfCompletedMaps(int userId){
        String sql = "Select map_id from resolved_maps where user_id = ?";
        return jdbcTemplate.queryForList(sql,Integer.class,userId);
    }

    @Override
    public List<Integer> getListOfInCompletedMaps(int userId) {
        String sql = "Select map_id from saves where user_id = ?";
        return jdbcTemplate.queryForList(sql,Integer.class,userId);
    }
}
