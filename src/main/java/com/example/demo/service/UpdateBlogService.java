package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Paksi Péter on 24/01/2018.
 */
@Service
public class UpdateBlogService {
    @Autowired
    BlogRepository blogRepository;

    @Transactional
    public void update(Blog blog, int id) {

    }
}
