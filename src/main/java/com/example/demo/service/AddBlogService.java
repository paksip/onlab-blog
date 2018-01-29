package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Service
public class AddBlogService {

    @Autowired
    BlogRepository blogRepository;

    @Transactional
    public void add(Blog blog) {

        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        blog.setDate(currentTime);

        blogRepository.save(blog);
    }

}
