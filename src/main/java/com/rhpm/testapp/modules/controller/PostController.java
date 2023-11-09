package com.rhpm.testapp.modules.controller;

import com.rhpm.testapp.modules.model.posts.Post;
import com.rhpm.testapp.modules.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation .*;

import java.util.List;

@Controller
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/post")
    public String showRegisterPost() {
        return "post";
    }

    @PostMapping(value = "/post")
    public String registerPost(@ModelAttribute Post post) {
        postService.createPost(post);
        return "post";
    }

    @GetMapping(value = "/get_posts")
    public @ResponseBody List<Post> getAllPost () {
        return postService.getAllPost();
    }
    @RequestMapping(value = "/create_post")
    public @ResponseBody Post createPost (@RequestBody Post post) {
        return postService.createPost(post);
    }
}
