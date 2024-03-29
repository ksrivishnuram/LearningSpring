package com.re5lect.sri.photos.clone.service;

import com.re5lect.sri.photos.clone.model.Photo;
import com.re5lect.sri.photos.clone.repository.PhotosRepository;
import org.springframework.stereotype.Service;
import java.util.*;

/*
basic functionality if service class is to interact with data and database
@Component and @Service both instantiate class when application boot up and are interchangeable
 */
@Service
public class PhotosService {
    private final PhotosRepository photosRepository;

    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public Iterable<Photo> get(){
        return photosRepository.findAll();
    }

    public Photo get(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo= new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }
}
