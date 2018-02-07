package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.dao.CommentRepository;
import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = simpleDateFormat.format(date);

        blog.setDate(currentTime);

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

        return blogRepository.findAll();
    }
}