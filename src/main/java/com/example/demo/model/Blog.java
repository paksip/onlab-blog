package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    private String text;

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
