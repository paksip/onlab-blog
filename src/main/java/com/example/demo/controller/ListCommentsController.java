package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import com.example.demo.service.ListBlogsService;
import com.example.demo.service.ListCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Paksi Péter on 29/01/2018.
 */
@EnableSwagger2
@Controller
public class ListCommentsController {

    @Autowired
    ListCommentsService listCommentsService;

    @CrossOrigin
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> get(@PathVariable int id){


        List<Comment> comments = listCommentsService.findCommentsByBlogId(id);

        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }

    //Set this header for every response to enable CORS
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
    }
}
