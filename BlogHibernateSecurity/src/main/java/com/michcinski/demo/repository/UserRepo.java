package com.michcinski.demo.repository;

import com.michcinski.demo.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<BlogUser,Long> {
    BlogUser findByUsername(String username);
}
