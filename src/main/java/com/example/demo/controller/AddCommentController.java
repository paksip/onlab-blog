package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import com.example.demo.service.AddBlogService;
import com.example.demo.service.AddCommentService;
import com.example.demo.service.FindBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Paksi Péter on 29/01/2018.
 */
@EnableSwagger2
@Controller
public class AddCommentController {

    @Autowired
    AddCommentService addCommentService; //service for adding...

    @Autowired
    FindBlogService findBlogService; //service for adding...

    @CrossOrigin
    @RequestMapping(value = "/addcomment/{id}", method = RequestMethod.POST)
    public ResponseEntity<Comment> add(@RequestBody Comment comment, @PathVariable int id){

        comment.setDate(new Date());
        addCommentService.add(id, comment);

        Blog blog = findBlogService.findBlogById(id);

        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    //Set this header for every response to enable CORS
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
    }
}
