package com.rhpm.testapp.modules.controller;

import com.rhpm.testapp.modules.model.posts.Post;
import com.rhpm.testapp.modules.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation .*;

import java.util.List;

@RestController
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/get_posts")
    public List<Post> getAllPost () {
        return postService.getAllPost();
    }
    @RequestMapping(value = "/create_post")
    public Post createPost (@RequestBody Post post) {
        return postService.createPost(post);
    }
}
