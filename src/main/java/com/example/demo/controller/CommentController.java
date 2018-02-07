package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Paksi Péter on 06/02/2018.
 */
@EnableSwagger2
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    //Add new comment for a blog
    @RequestMapping(value = "/addcomment/{id}", method = RequestMethod.POST)
    public ResponseEntity<Comment> add(@RequestBody Comment comment, @PathVariable int id){

        commentService.add(id, comment);

        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    //Delete a comment by id
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {

        commentService.delete(id);
    }

    //List all comments for a blog
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Comment>> get(@PathVariable("id") int id){

        Iterable<Comment> comments = commentService.findCommentsByBlogId(id);

        return new ResponseEntity<Iterable<Comment>>(comments, HttpStatus.OK);
    }
}