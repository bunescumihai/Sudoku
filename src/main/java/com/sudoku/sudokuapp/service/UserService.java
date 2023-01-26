package com.sudoku.sudokuapp.service;

import com.sudoku.sudokuapp.entity.User;

import java.util.List;

public interface UserService {
    User getUserByCredentials(String login, String password);

    List<User> getAllUsers();

    List<Integer> getListOfCompletedMaps(int userId);

    List<Integer> getListOfInCompletedMaps(int userId);
}
