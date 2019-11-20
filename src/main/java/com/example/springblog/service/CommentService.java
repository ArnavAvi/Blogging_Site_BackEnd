package com.example.springblog.service;

import com.example.springblog.model.Comment;
import com.example.springblog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> show() {
        return commentRepository.findAll();
    }

    public Comment add(Comment comment) {
        comment.setCommentDate(new Date());
        return commentRepository.save(comment);
    }

    /*public List<Comment> getById(long id) {
        return commentRepository.findAllByPostId(id);
    }*/
}
