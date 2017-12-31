package com.lucassartori.service.implementation;

import com.lucassartori.model.User;
import com.lucassartori.dao.UserDAO;
import com.lucassartori.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sartori on 21/10/2017
 */
@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    public List<User> findAllUsers() {
        return dao.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return dao.findByUserName(userName);
    }

    @Override
    public User save(User user) {
        return dao.save(user);
    }
}
