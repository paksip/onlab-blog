package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;

/**
 * Created by Paksi Péter on 27/02/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")
@EnableSwagger2
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registrate", method = RequestMethod.POST)
    public ResponseEntity<User> add(@RequestBody User user) throws NoSuchAlgorithmException {

        try {
            userService.register(user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
