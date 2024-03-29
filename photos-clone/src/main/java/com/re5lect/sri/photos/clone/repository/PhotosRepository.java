package com.re5lect.sri.photos.clone.repository;
import com.re5lect.sri.photos.clone.model.Photo;
import org.springframework.data.repository.CrudRepository;
/*
CrudRepository gives CRUD method, so need to write one for that ops.
 */
public interface PhotosRepository extends CrudRepository<Photo, Integer> {

}
