package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.AddBlogService;
import com.example.demo.service.UpdateBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Paksi Péter on 24/01/2018.
 */
@Controller
@EnableSwagger2
public class UpdateBlogController {
    @Autowired
    UpdateBlogService updateBlogService; //service for adding...

    @CrossOrigin
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blog> update(@PathVariable("id") int itemId, @RequestBody Blog blog){

        if(blog == null){
            return new ResponseEntity<Blog>(blog, HttpStatus.NO_CONTENT);
        }
        updateBlogService.update(blog, itemId);
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    //Set this header for every response to enable CORS
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
    }


}
