package com.lucassartori.controller;

import com.lucassartori.model.Photo;
import com.lucassartori.model.User;
import com.lucassartori.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class PhotoResource {

    private String imageName;

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public String upload(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
        MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
        this.imageName = multipartFile.getOriginalFilename();

        String path = new File("/Users/sartori/Sites/workspace-cursos/src/main/resources/images").getAbsolutePath() + "/" + this.imageName;

        try {
            multipartFile.transferTo(new File(path));
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Upload Success!";
    }


    @RequestMapping(value = "/photo/add", method = RequestMethod.POST)
    public Photo addPhoto(@RequestBody Photo photo) {
        photo.setImageName(this.imageName);
        return this.photoService.save(photo);
    }


    @RequestMapping(value = "/photo/photoId", method = RequestMethod.POST)
    public List<Photo> getPhotosByUser(@RequestBody User user) {
       return this.photoService.findByUser(user);
    }

    @RequestMapping(value = "/photo/user", method = RequestMethod.POST)
    public Photo getPhotosById(@RequestBody Long photoId) {
        return this.photoService.findByPhotoId(photoId);
    }

    @RequestMapping(value = "/photo/update", method = RequestMethod.POST)
    public void updatePhoto(@RequestBody Photo photo) {
        Photo currentPhoto = this.photoService.findByPhotoId(photo.getPhotoId());
        currentPhoto.setLikes(photo.getLikes());
        this.photoService.save(currentPhoto);
    }
}
