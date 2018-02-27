package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.dao.CommentRepository;
import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

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
    public Iterable<Comment> add(int blogId, Comment comment) {

        Blog blog = blogRepository.findOne(blogId);
        comment.setBlog(blog);

        Date currentDate = new Date();
        comment.setDate(currentDate);

        commentRepository.save(comment);
        blog.addComment(comment);
        blogRepository.save(blog);

        return commentRepository.findAll();
    }

    //Delete a comment
    @Transactional
    public void delete(int id) {

        Comment comment = commentRepository.findOne(id);
        commentRepository.delete(comment);
    }

    //Get all comments for a blog
    @Transactional
    public Iterable<Comment> findCommentsByBlogId(int id){

        Blog blog = blogRepository.findOne(new Integer(id));

       return commentRepository.findAllByBlog(blog);
    }
}