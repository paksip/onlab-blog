package com.example.demo.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String text;


    private String date;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {

        return date;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    @JsonIgnore
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;


    public List<Comment> getComments() {
        return comments;
    }

    public void setComment(Comment comment) {
        this.comments.add(comment);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    //private Date created;
}
