package com.example.springblog.service;

import com.example.springblog.model.Post2;
import com.example.springblog.repository.Post2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Post2Service {
    private Post2Repository post2Repository;
    @Autowired
    public Post2Service(Post2Repository post2Repository) {
        this.post2Repository = post2Repository;
    }

    public List<Post2> show()
    {
        return post2Repository.findAll();
    }

    public Post2 addPost(Post2 p) {
        p.setCreatedOn(new Date());
        return post2Repository.save(p);
    }

    public Post2 editPost(Post2 p) {
        p.setUpdatedOn(new Date());
        return post2Repository.save(p);
    }

    public Post2 getPostById(long id)
    {
        return post2Repository.findBypostId(id);
    }


    public List<Post2> getByMail(String name) {
        return post2Repository.findAllByAuthor(name);
    }

    public String getUserName(Principal principal) {
       // System.out.println("principal:" + principal);
        String email = principal.getName(); //*idkwthisgName*//*
        return email;
        // return post2Repository.findByEmail(email).getUserId();
    }

    public void deleteById(long id) {
        post2Repository.deleteById(id);
    }

    public Post2 getByPrincipal(Principal principal) {
        return null;
    }
}
