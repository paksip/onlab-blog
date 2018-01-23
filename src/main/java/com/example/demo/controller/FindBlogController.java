package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.FindBlogService;
import com.example.demo.service.ListBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Paksi Péter on 23/01/2018.
 */
@Controller
public class FindBlogController {
    @Autowired
    FindBlogService findBlogService;


    @CrossOrigin
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){


        Blog b = findBlogService.findBlogById(id);

        return new ResponseEntity<Blog>(b, HttpStatus.OK);
    }

    //Set this header for every response to enable CORS
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
    }


}
