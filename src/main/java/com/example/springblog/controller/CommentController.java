package com.example.springblog.controller;

import com.example.springblog.model.Comment;
import com.example.springblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/comment",method ={RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST
})
public class CommentController {

    @Autowired
    CommentService commentService;
    @GetMapping("/all")
    public List<Comment> shows()
    {
        return commentService.show();
    }
    @PostMapping("addComment")
    public Comment add(@RequestBody Comment comment) { return commentService.add(comment);}
    /*@GetMapping("getByPostId/{id}")
    public List<Comment> getById(@PathVariable("id") long id) { return commentService.getById(id); }*/
}
