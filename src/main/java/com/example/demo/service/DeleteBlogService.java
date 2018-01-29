package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.dao.CommentRepository;
import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Service
public class DeleteBlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;

    @Transactional
    public void delete(@PathVariable("id") int itemId) {
        Blog blog = blogRepository.findOne(itemId);
        List<Comment> comments = commentRepository.findAllByBlog(blog);

        commentRepository.delete(comments);
        blogRepository.delete(blog);
    }
}
