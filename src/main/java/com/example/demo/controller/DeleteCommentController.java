package com.example.demo.controller;

import com.example.demo.service.DeleteBlogService;
import com.example.demo.service.DeleteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Paksi Péter on 29/01/2018.
 */
@EnableSwagger2
@Controller
public class DeleteCommentController {
    @Autowired
    DeleteCommentService deleteCommentService;

    @CrossOrigin
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int itemId) {
        deleteCommentService.delete(itemId);
    }

    //Set this header for every response to enable CORS
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
    }
}
