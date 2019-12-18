package com.michcinski.demo.service;

import com.michcinski.demo.model.Post;
import com.michcinski.demo.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    @Override
    public void savePost(Post newPost) {
        postRepo.save(newPost);
    }

    @Override
    public List<Post> getPostList() {
        return postRepo.findAll();
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void modifyPost( Post modifiedPost){
        postRepo.save(modifiedPost);
    }

    @Override
    public Post getOne(Long id) {
        return postRepo.findPostById(id);
    }
}
