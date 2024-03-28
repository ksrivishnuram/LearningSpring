package com.re5lect.sri.photos.clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
creates the instance of the class
 */
public class PhotosController {
    @GetMapping("/")
    /*
    method get executed when endpoint / with http request called
     */
    public String hello(){
        return "hello";
    }
}
