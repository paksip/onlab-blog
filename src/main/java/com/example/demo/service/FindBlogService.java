package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paksi Péter on 23/01/2018.
 */
@Service
public class FindBlogService {

    @Autowired
    BlogRepository blogRepository;

    @Transactional
    public Blog findBlogById(int i){

        Blog b = blogRepository.findOne(new Integer(i));

        return b;
    }
}
