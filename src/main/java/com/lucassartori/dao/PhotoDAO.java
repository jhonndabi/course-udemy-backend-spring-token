package com.lucassartori.dao;

import com.lucassartori.model.Photo;
import com.lucassartori.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDAO extends CrudRepository<Photo, Long> {

    Photo save(Photo photo);

    List<Photo> findByUser(User user);

    List<Photo> findAll();

    Photo findByPhotoId(Long photoId);
}
