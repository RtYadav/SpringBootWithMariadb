package com.idemia.SpringbootWithMariadbAss.controller;

import com.idemia.SpringbootWithMariadbAss.model.User;
import com.idemia.SpringbootWithMariadbAss.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepo userRepo;
    private static final String SAVE = "/save";
    private static final String GET = "/get";
    private static final String DELETE = "/delete/{id}";
    @PostMapping(SAVE)
    public void saveUser(@RequestBody User user){
        userRepo.save(user);
    }
    @GetMapping(GET)
    public List getUser(){
        ArrayList list = new ArrayList();
        list.add(userRepo.findAll());
        return list;
    }
    @DeleteMapping(DELETE)
    public void deleteUser(@PathVariable (value = "id")Long userId){
        User u = userRepo.findById(userId).get();
        userRepo.delete(u);
    }

}
