package com.example.springblog.controller;

import com.example.springblog.dto.LoginRequest;
import com.example.springblog.dto.RegisterRequest;
import com.example.springblog.model.User;
import com.example.springblog.service.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return authService.addUser(user);
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return authService.getUsers();
    }

    @GetMapping("/age")
    public String tryit() {
        return "\"valid\"";
    }

    @GetMapping("/getUserById/{id}")
     public User getCurrentById(@PathVariable("id") Long id) {
        return authService.getUserById(id);
    }

    @GetMapping("/getUserByEmail/{email}")   // CHECK_RED
    public User getCurrentByEmail(@PathVariable("email") String email) {
        return authService.getUserByEmail(email);
    }

    @GetMapping("/retrieveViaToken/{token}")
    public String retrieveViaToken(@PathVariable ("token") Principal token) {
        return authService.retrieveViaToken((long) 12356);
    }

    @GetMapping("/getUserByName/{name}")   // CHECK_RED
    public User getByName(@PathVariable("name") String name) {
        return authService.getByName(name);
    }

    /*@PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);

    }*/
}
