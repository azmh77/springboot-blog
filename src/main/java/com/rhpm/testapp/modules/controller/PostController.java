package com.rhpm.testapp.modules.controller;

import com.rhpm.testapp.modules.model.posts.Post;
import com.rhpm.testapp.modules.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation .*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/posts")
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "")
    public String showRegisterPost() {
        return "post";
    }

    @PostMapping(value = "")
    public String registerPost(@ModelAttribute Post post) throws IOException {
        postService.createPost(post);
        return "post";
    }

    @GetMapping(value = "/rest")
    public @ResponseBody List<Post> getAllPost () {
        return postService.getAllPost();
    }
    @RequestMapping(value = "/rest")
    public @ResponseBody Post createPost (@RequestBody Post post) throws IOException {
        return postService.createPost(post);
    }
}
