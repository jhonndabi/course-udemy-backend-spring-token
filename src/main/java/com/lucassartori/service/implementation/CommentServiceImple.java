package com.lucassartori.service.implementation;

import com.lucassartori.dao.CommentDAO;
import com.lucassartori.model.Comment;
import com.lucassartori.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImple implements CommentService {

    @Autowired
    private CommentDAO commentDAO;
    @Override
    public Comment save(Comment comment) {
        return this.commentDAO.save(comment);
    }

    @Override
    public Comment findOne(Long id) {
        return this.commentDAO.findOne(id);
    }

    @Override
    public List<Comment> findByPhotoId(Long id) {
        return this.commentDAO.findByPhotoId(id);
    }
}
