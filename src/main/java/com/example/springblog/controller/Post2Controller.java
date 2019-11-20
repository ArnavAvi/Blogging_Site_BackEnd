package com.example.springblog.controller;

import com.example.springblog.model.Post2;
import com.example.springblog.service.Post2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/post",method ={RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST
})
public class Post2Controller {

    @Autowired
    Post2Service post2Service;
    @GetMapping("/all")
    public List<Post2> shows()
    {
        return post2Service.show();
    }
    @PostMapping("/addPost")
    public Post2 add(@RequestBody Post2 p)
    {
        return post2Service.addPost(p);
    }
    @PutMapping("/editPost")
    public Post2 edit(@RequestBody Post2 p)
    {
        return post2Service.editPost(p);
    }
    @GetMapping("viewPostById/{id}")
    public Post2 showById(@PathVariable("id") long id)
    {
        return  post2Service.getPostById(id);
    }

    @DeleteMapping("/deletePost/{id}")
    public String deleteById(@PathVariable("id") long id)
    {
        post2Service.deleteById(id);
        return "\"Deleted Data by Id\"";
    }

    @GetMapping("/getUserPostsByMail/{name}")   //  CHECK RED
    public List<Post2> getByMail(@PathVariable("name") String name) {
        return post2Service.getByMail(name);
    }

    @GetMapping("/getUserByToken/{token}")
    public String getUserName(@PathVariable("token") Principal principal) {
        return post2Service.getUserName(principal);
    }
}
