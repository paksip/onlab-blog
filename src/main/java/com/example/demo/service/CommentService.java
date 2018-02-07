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
public class CommentService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;

    //Add a comment to a blog
    @Transactional
    public void add(int blogId, Comment comment) {

        Blog blog = blogRepository.findOne(blogId);
        comment.setBlog(blog);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = simpleDateFormat.format(date);

        comment.setDate(currentTime);

        commentRepository.save(comment);
        blog.setComment(comment);
        blogRepository.save(blog);
    }

    //Delete a comment
    @Transactional
    public void delete(int id) {

        Comment comment = commentRepository.findOne(id);
        commentRepository.delete(comment);
    }

    //Get all comments for a blog
    @Transactional
    public List<Comment> findCommentsByBlogId(int id){

        Blog blog = blogRepository.findOne(new Integer(id));

        return commentRepository.findAllByBlog(blog);
    }
}