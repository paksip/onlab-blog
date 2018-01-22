package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Service
public class ListBlogsService {

    @Autowired
    BlogRepository blogRepository;

    @Transactional
    public List<Blog> getAll(){

        List<Blog> blogs = (List<Blog>) blogRepository.findAll();

        return blogs;
    }
}
