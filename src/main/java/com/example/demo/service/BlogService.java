package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * Created by Paksi Péter on 06/02/2018.
 */
@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    //Add a blog
    @Transactional
    public void add(Blog blog) {

        Date currentDate = new Date();
        blog.setDate(currentDate);

        blogRepository.save(blog);
    }

    //Delete a blog
    @Transactional
    public void delete(int id) {

        Blog blog = blogRepository.findOne(id);

        blogRepository.delete(blog);
    }

    //Get a blog
    @Transactional
    public Blog findBlogById(int id){

        Blog blog = blogRepository.findOne(new Integer(id));

        return blog;
    }

    //Get all blogs
    @Transactional
    public Iterable<Blog> getAll(){

        Iterable<Blog> blogs = blogRepository.findAll();

        return blogs;
    }
}