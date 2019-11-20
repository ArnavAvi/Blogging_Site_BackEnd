/*package com.example.springblog.service;
import com.example.springblog.dto.LoginRequest;
import com.example.springblog.dto.RegisterRequest;
import com.example.springblog.model.User;
import com.example.springblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;
import java.util.Optional;*/

package com.example.springblog.service;

import com.example.springblog.model.User;
import com.example.springblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;



@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

public User addUser(User user) {
    user.setRole("user");
    return userRepository.save(user);
}


public List<User> getUsers() {
    return userRepository.findAll();
}

    public long getUserIds(Principal principal) {
        System.out.println("principal:" + principal);
        String email = principal.getName();     /*idkwthisgName*/
        return userRepository.findByEmail(email).getUserId();
    }

    public User getUserById(Long id) { return userRepository.findByUserId(id);}

    public User getUserByEmail(String email) { return userRepository.findByEmail(email);}

    public User getByName(String name) { return userRepository.findByUserName(name); }
    public String retrieveViaToken(Long a) { return "Chal raha hai!!";}
  /*
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    public void signup(RegisterRequest registerRequest) {
        User user=new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);

    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
        //return password;
    }

    public String login(LoginRequest loginRequest) {
       Authentication authenticate=  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return jwtProvider.genrateToken(authenticate);
    }
    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
*/

}
