package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Paksi Péter on 27/02/2018.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public HttpStatus register(User userClient) throws NoSuchAlgorithmException {

        if(userRepository.findByUsernameOrEmail(userClient.getUsername(), userClient.getEmail()) != null){ //It already exists
            return HttpStatus.FORBIDDEN; //403
        }
        //Encrypt user's password
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(userClient.getPassword().getBytes());
            userClient.setPassword(new String(messageDigest.digest()));
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        userRepository.save(userClient);
        return HttpStatus.OK;
    }

    public HttpStatus auth(User userClient) throws NoSuchAlgorithmException{

        String passwordClientEncrypted = "";

        //Exist by username?
        User user = userRepository.findByUsername(userClient.getUsername());
        if(user == null){
            return HttpStatus.FORBIDDEN; //403
        }
        //Encrypt given password
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(userClient.getPassword().getBytes());
            passwordClientEncrypted =  new String(messageDigest.digest());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        //Check password
        if(!user.getPassword().equals(passwordClientEncrypted)){
            return HttpStatus.FORBIDDEN; //403
        }
        return HttpStatus.OK;

    }
}
