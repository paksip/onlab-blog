package com.example.demo.model;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

/**
 * Created by Paksi Péter on 09/02/2018.
 */
public class BlogTest {

    @Test
    public void testBlogConstructorNoParams(){
        Blog blog = new Blog();

        assertNotNull(blog);
    }

    @Test
    public void testBlogSetTitle(){
        Blog blog = new Blog();
        blog.setTitle("First");

        assertEquals("First", blog.getTitle());
    }

    @Test
    public void testBlogWithComments(){
        Blog blog = new Blog();

        ArrayList<Comment> comments = new ArrayList<>();
        for(int i = 0; i<5; i++){
            comments.add(new Comment());
        }
        blog.setComments(comments);

        assertNotNull(blog.getComments());
        assertEquals(5, blog.getComments().size());


    }
}
