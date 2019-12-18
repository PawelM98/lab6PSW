//package com.michcinski.demo;
//
//import com.michcinski.demo.model.Post;
//import com.michcinski.demo.repository.PostRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Start {
//    private PostRepo postRepo;
//
//    @Autowired
//    public Start(PostRepo postRepo){
//        this.postRepo = postRepo;
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void addStartingPosts(){
//        postRepo.save(new Post("title one","this is post for title one"));
//        postRepo.save(new Post("title Two","Title two is second title and it have post two"));
//        postRepo.save(new Post("AMW TITLE THREE","Hello Blog AMW"));
//    }
//}
