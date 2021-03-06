package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
    @Lob
    private String text;

    @NotNull
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Date getDate() {

        return date;
    }

    public Blog getBlog() {
        return blog;
    }

}

