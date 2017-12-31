package com.lucassartori.dao;

import com.lucassartori.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sartori on 21/10/2017
 */
@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByUserName(String userName);

    User findByUserId(Long userId);

    User save(User user);
}
