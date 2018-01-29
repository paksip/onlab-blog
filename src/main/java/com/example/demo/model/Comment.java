package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Paksi Péter on 29/01/2018.
 */
@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String text;

    @NotNull
    private String author;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;


    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {

        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}