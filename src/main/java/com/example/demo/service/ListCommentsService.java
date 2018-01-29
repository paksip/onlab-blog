package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.dao.CommentRepository;
import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paksi Péter on 29/01/2018.
 */
@Service
public class ListCommentsService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;

    @Transactional
    public List<Comment> findCommentsByBlogId(int i){

        Blog b = blogRepository.findOne(new Integer(i));

        return commentRepository.findAllByBlog(b);
    }
}
