package com.lucassartori.service;

import com.lucassartori.model.Photo;
import com.lucassartori.model.User;

import java.util.List;

public interface PhotoService {

    Photo save(Photo photo);

    List<Photo> findAll();

    List<Photo> findByUser(User user);

    Photo findByPhotoId(Long photoId);

}
