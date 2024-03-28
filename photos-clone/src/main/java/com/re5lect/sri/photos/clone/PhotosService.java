package com.re5lect.sri.photos.clone;

import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
basic functionality if service class is to interact with data and database
@Component and @Service both instantiate class when application boot up and are interchangeable
 */
@Service
public class PhotosService {
    private Map<String, Photo> db= new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};
    public Collection<Photo> get(){
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName, byte[] data) {
        Photo photo= new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
}
