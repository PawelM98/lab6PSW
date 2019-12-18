package com.michcinski.demo.service;

import com.michcinski.demo.model.Post;

import java.util.List;
public interface PostService {
    void savePost(Post newPost);
    List<Post> getPostList();
    void deletePost(Long id);
    void modifyPost(Post modifiedPost);
    Post getOne(Long id);
}
