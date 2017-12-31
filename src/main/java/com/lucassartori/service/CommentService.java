package com.lucassartori.service;

import com.lucassartori.model.Comment;

import java.util.List;

public interface CommentService {

    Comment save(Comment comment);

    Comment findOne(Long id);

    List<Comment> findByPhotoId(Long id);
}
