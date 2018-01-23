package com.example.demo.controller;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import com.example.demo.service.AddBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Controller
public class AddBlogController {


    @Autowired
    AddBlogService addBlogService; //service for adding...

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Blog> update(@RequestBody Blog blog){

        if(blog == null){
            return new ResponseEntity<Blog>(blog, HttpStatus.NO_CONTENT);
        }
        addBlogService.add(blog);
        return new ResponseEntity<Blog>(blog, HttpStatus.CREATED);
    }

    //Set this header for every response to enable CORS
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
    }





}
