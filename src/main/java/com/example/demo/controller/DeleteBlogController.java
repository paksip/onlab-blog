package com.example.demo.controller;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import com.example.demo.service.DeleteBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Paksi Péter on 19/01/2018.
 */

@Controller
public class DeleteBlogController {

    @Autowired
    DeleteBlogService deleteBlogService;

    @CrossOrigin
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int itemId) {
        deleteBlogService.delete(itemId);
    }

    //Set this header for every response to enable CORS
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
    }
}
