package com.lucassartori.service;

import com.lucassartori.model.User;

import java.util.List;

/**
 * Created by sartori on 21/10/2017
 */
public interface UserService {

    List<User> findAllUsers();

    User findByUserName(String userName);

    User save(User user);
}
