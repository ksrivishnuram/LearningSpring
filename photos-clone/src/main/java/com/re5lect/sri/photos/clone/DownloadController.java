package com.re5lect.sri.photos.clone;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        byte[] data= new byte[0];
        HttpHeaders headers= new HttpHeaders();
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
