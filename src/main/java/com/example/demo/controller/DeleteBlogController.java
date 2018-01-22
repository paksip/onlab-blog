package com.example.demo.controller;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import com.example.demo.service.DeleteBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Controller
public class DeleteBlogController {

    @Autowired
    DeleteBlogService deleteBlogService;

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int itemId) {
        deleteBlogService.delete(itemId);
    }
}
