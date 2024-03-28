package com.re5lect.sri.photos.clone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
/*
creates the instance of the class
 */
public class PhotosController {
    private Map<String, Photo> db= new HashMap<>(){{
    put("1", new Photo("1", "hello.jpg"));
    }};
    @GetMapping("/")
    /*
    method get executed when endpoint / with http request called
     */
    public String hello(){
        return "hello";
    }
    @GetMapping("/photos")
    public Collection<Photo> get(){
        return db.values();
    }
    @GetMapping("/photos/{id}")
    /*
    pathVariable matches id in the path , sets  the parameter for the method
     */
    public Photo get(@PathVariable String id){
        Photo photo= db.get(id);
//        throws status error code:404 when photo is not available
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id){
        Photo photo= db.remove(id);
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
