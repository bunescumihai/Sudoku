package com.sudoku.sudokuapp.service.impl;

import com.sudoku.sudokuapp.entity.User;
import com.sudoku.sudokuapp.repository.UserRepository;
import com.sudoku.sudokuapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByCredentials(String login, String password) {
        if(userRepository.existsUser(login,password))
            return userRepository.getUserByCredentials(login, password);
        else
            return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<Integer> getListOfCompletedMaps(int userId) {
        return this.userRepository.getListOfCompletedMaps(userId);
    }

    @Override
    public List<Integer> getListOfInCompletedMaps(int userId) {
        return this.userRepository.getListOfInCompletedMaps(userId);
    }
}
