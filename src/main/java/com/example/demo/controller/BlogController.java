package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;


/**
 * Created by Paksi Péter on 06/02/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")
@EnableSwagger2
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    //Add new blog
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Blog> add(@RequestBody Blog blog){

        if(blog == null){
            return new ResponseEntity<Blog>(blog, HttpStatus.NO_CONTENT);
        }

        blogService.add(blog);
        return new ResponseEntity<Blog>(blog, HttpStatus.CREATED);
    }

    //Search in blogs
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<Iterable<Blog>> search(@RequestBody String search){

        Iterable<Blog> blogs = blogService.search(search);
        return new ResponseEntity<Iterable<Blog>>(blogs, HttpStatus.OK);
    }

    //Get a blog by id
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id){

        Blog blog = blogService.findBlogById(id);

        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    //List all blogs
    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Blog>> get() throws MalformedURLException {

        Iterable<Blog> blogs = blogService.getAll();

//        //Kitérő - BitCoin árfolyam lekérdezése MrCoin oldalról/////////////////////////////////////////////////////////////////
//
//        try {
//
//            URLConnection connection = new URL("https://www.mrcoin.eu/hu/").openConnection();
//            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
//            connection.connect();
//
//            BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
//
//            StringBuilder sb = new StringBuilder();
//            String line;
//            String filterLine = "";
//            while ((line = r.readLine()) != null) {
//                if(line.indexOf("Ennyiért adjuk: ") != -1){
//                    filterLine = line;
//                    break;
//                }
//            }
//            filterLine = filterLine.replaceAll("\\D+","");
//            int actualBitCoinExchangeRate = new Integer(filterLine);
//
//            System.out.println(actualBitCoinExchangeRate + " Ft");
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        return new ResponseEntity<Iterable<Blog>>(blogs, HttpStatus.OK);
    }

    //Delete one blog by id
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {

        blogService.delete(id);
    }
}