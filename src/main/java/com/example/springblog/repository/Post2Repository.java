package com.example.springblog.repository;


import com.example.springblog.model.Post2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Post2Repository extends JpaRepository<Post2,Long> {

    List<Post2> findAllByAuthor(String name);

    Post2 findBypostId(long id);

}
