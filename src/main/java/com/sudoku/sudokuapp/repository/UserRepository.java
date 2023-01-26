package com.sudoku.sudokuapp.repository;

import com.sudoku.sudokuapp.entity.User;

import java.util.List;

public interface UserRepository {

    void create(User user);

    User getUserByCredentials(String login, String password);

    boolean existsUser(String login, String password);

    List<User> getAllUsers();

    List<Integer> getListOfCompletedMaps(int userId);

    List<Integer> getListOfInCompletedMaps(int userId);
}
