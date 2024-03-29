package com.re5lect.sri.photos.clone.web;

import com.re5lect.sri.photos.clone.model.Photo;
import com.re5lect.sri.photos.clone.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;
/*
functionality of controller class is to convert to json to object and vice versa
 */
@RestController
/*
creates the instance of the class
 */
public class PhotosController {
    private final PhotosService photosService;

    public PhotosController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/")
    /*
    method get executed when endpoint / with http request called
     */
    public String hello(){
        return "hello";
    }
    @GetMapping("/photos")
    public Iterable<Photo> get(){
        return photosService.get();
    }
    /*
    pathVariable matches id in the path , sets  the parameter for the method
     */
    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo= photosService.get(id);
//        throws status error code:404 when photo is not available
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id){
        photosService.remove(id);
    }
    @PostMapping("/photos")
    /*
    functionality in springboot that converts json from frontend to the photo object
    requestBody: takes the whole json and convert to object
    valid: a checkpoint to validate if fileName is not null
     */
    /*
    once the html is added no needed of requestBody and valid
    convert fileUpload to multipartFile, which is a springBoot file
    RequestPart("data") : marker which denotes from which part data is coming
     */
    /*
    the browser needs to upload the file with fileName and contentType(jpeg/png..)
     */
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

//        setting in memory database
        Photo photo= photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
