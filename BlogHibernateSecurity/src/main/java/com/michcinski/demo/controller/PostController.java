package com.michcinski.demo.controller;

import com.michcinski.demo.model.Post;
import com.michcinski.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public  PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/")
    public String getPostList(Model model){
        model.addAttribute("postList",postService.getPostList());
        model.addAttribute("deletedPost",postService.getPostList());
        model.addAttribute("newPost",new Post());
        model.addAttribute("modifiedPost",new Post());
        return "home";
    }

    @PostMapping
    public String addPost(@ModelAttribute("newPost") Post newPost, Model model){
        postService.savePost(newPost);
        model.addAttribute("newPost",newPost);
        return "redirect:/";
    }

    @GetMapping("deletePost/{id}")
    public String deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("editPost/{id}")
    public String editPost(@PathVariable Long id,Model model){
        Post updating = postService.getOne(id);
        model.addAttribute("modifiedPost",updating);
        return "modify";
    }

    @PostMapping("updatePost/{id}")
    public String updatePost(@PathVariable Long id){
        postService.modifyPost(postService.getOne(id));
        return "redirect:/";
    }
    @GetMapping("error")
    public String errorBlog(){
        return "errorPage";
    }

}
