package com.sudoku.sudokuapp.controller;

import com.sudoku.sudokuapp.entity.User;
import com.sudoku.sudokuapp.repository.UserRepository;
import com.sudoku.sudokuapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    private User getUserByCredentials(@RequestParam String login, @RequestParam String password){
        return userService.getUserByCredentials(login, password);
    }

    @GetMapping("/all")
    private List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    void createUser(@RequestBody User user){
        userRepository.create(user);
    }

    @GetMapping("profile/completed")
    public List<Integer> getListOfCompletedMaps(@RequestParam int userId){
        return userService.getListOfCompletedMaps(userId);
    }

    @GetMapping("profile/incompleted")
    public List<Integer> getListOfInCompletedMaps(int userId){
        return userService.getListOfInCompletedMaps(userId);
    }
}
