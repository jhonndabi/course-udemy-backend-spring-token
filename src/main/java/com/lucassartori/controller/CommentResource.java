package com.lucassartori.controller;

import com.lucassartori.model.Comment;
import com.lucassartori.model.Photo;
import com.lucassartori.service.CommentService;
import com.lucassartori.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CommentResource {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public void addComment(@RequestBody Comment comment) {
        Photo photo = this.photoService.findByPhotoId(comment.getPhotoId());
        List<Comment> commentList = photo.getCommentList();
        comment.setPhoto(photo);
        commentService.save(comment);
    }
}
