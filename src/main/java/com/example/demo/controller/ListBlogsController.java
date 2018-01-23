package com.example.demo.controller;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import com.example.demo.service.ListBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Controller
public class ListBlogsController {

    @Autowired
    ListBlogsService listBlogsService;

    @CrossOrigin
    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> get(){


        List<Blog> blogs = listBlogsService.getAll();

        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    //Set this header for every response to enable CORS
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
    }


}
