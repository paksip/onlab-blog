package com.example.demo.dao;

import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Paksi Péter on 29/01/2018.
 */
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    List<Comment> findAllByBlog(Blog blog);
}
