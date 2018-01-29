package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.dao.CommentRepository;
import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Paksi Péter on 29/01/2018.
 */
@Service
public class DeleteCommentService {

    @Autowired
    CommentRepository commentRepository;

    @Transactional
    public void delete(@PathVariable("id") int itemId) {
        Comment c = commentRepository.findOne(itemId);
        commentRepository.delete(c);
    }
}
