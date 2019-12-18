package com.michcinski.demo.repository;

import com.michcinski.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
        void deleteById(Long id);
        Post findPostById(Long id);
}
