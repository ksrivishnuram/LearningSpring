package com.re5lect.sri.photos.clone.web;

import com.re5lect.sri.photos.clone.model.Photo;
import com.re5lect.sri.photos.clone.service.PhotosService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
/*
restController: instantiate the class, whenever the application boot up
 */
public class DownloadController {
    /*
    sending bytes to the browser
    sends raw byte to the browser which is wrapped by response entity
     */
    private final PhotosService photosService;

    public DownloadController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){
        Photo photo= photosService.get(id);
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[] data= photo.getData();
        HttpHeaders headers= new HttpHeaders();
//      to set the photo in specific type inorder send back the image in jpeg/png
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
//      browser needs fileName
//      to download the browser automatically
        ContentDisposition build= ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        /*
        to display image in the browser automatically
        ContentDisposition build= ContentDisposition.builder("inline").build();
         */
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
