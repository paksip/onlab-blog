package com.example.demo.dao;

import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Paksi Péter on 27/02/2018.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
     User findByUsernameOrEmail(String username, String email);


}
