package com.example.demo.controller;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import com.example.demo.service.AddBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Controller
public class AddBlogController {


    @Autowired
    AddBlogService addBlogService; //service for adding

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Blog> update(@RequestBody Blog blog){

        if(blog == null){
            return new ResponseEntity<Blog>(blog, HttpStatus.NO_CONTENT);
        }
        addBlogService.add(blog);
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }



    @RequestMapping(value = "/")
    public ResponseEntity<Blog> get(){
        Blog blog = new Blog();
        blog.setText("blabla");
        blog.setTitle("Elso blogom");

        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

}
