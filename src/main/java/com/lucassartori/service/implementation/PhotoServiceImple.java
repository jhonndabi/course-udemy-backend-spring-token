package com.lucassartori.service.implementation;

import com.lucassartori.dao.PhotoDAO;
import com.lucassartori.model.Photo;
import com.lucassartori.model.User;
import com.lucassartori.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImple implements PhotoService {

    @Autowired
    private PhotoDAO photoDao;

    public Photo save(Photo photo) {
        return photoDao.save(photo);
    }

    public List<Photo> findAll() {
        return photoDao.findAll();
    }

    public List<Photo> findByUser(User user) {
        return photoDao.findByUser(user);
    }

    public Photo findByPhotoId(Long photoId) {
        return photoDao.findByPhotoId(photoId);
    }
}
