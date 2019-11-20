package com.example.springblog.repository;

import com.example.springblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);

/*
    @Query(value = "select q from User q where q.email = ?1")
*/
    User findByEmail(String email);

    User findByUserId(Long id);
}
