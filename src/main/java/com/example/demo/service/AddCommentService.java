package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.dao.CommentRepository;
import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Paksi Péter on 29/01/2018.
 */
@Service
public class AddCommentService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;

    @Transactional
    public void add(int blogId, Comment comment) {
        Blog b = blogRepository.findOne(blogId);
        comment.setBlog(b);

        commentRepository.save(comment);

        b.setComment(comment);

        blogRepository.save(b);

    }
}
