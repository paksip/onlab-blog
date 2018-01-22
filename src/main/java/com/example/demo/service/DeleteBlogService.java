package com.example.demo.service;

import com.example.demo.dao.BlogRepository;
import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Service
public class DeleteBlogService {

    @Autowired
    BlogRepository blogRepository;

    @Transactional
    public void delete(@PathVariable("id") int itemId) {
        Blog blog = blogRepository.findOne(itemId);
        blogRepository.delete(blog);
    }
}
