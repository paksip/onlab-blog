package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Paksi Péter on 27/02/2018.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void register(User user){

        userRepository.save(user);

    }
}
