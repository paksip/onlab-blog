package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by Paksi Péter on 06/02/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")
@EnableSwagger2
@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    //Add new blog
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Blog> add(@RequestBody Blog blog){

        if(blog == null){
            return new ResponseEntity<Blog>(blog, HttpStatus.NO_CONTENT);
        }

        blogService.add(blog);
        return new ResponseEntity<Blog>(blog, HttpStatus.CREATED);
    }

    //Get a blog by id
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id){

        Blog blog = blogService.findBlogById(id);

        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    //List all blogs
    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Blog>> get(){

        Iterable<Blog> blogs = blogService.getAll();

        return new ResponseEntity<Iterable<Blog>>(blogs, HttpStatus.OK);
    }

    //Delete one blog by id
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {

        blogService.delete(id);
    }
}