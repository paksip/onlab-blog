package com.example.demo.dao;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by Paksi Péter on 19/01/2018.
 */
public interface BlogRepository extends CrudRepository<Blog, Integer> {

}
