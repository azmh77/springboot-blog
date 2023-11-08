package com.rhpm.testapp.modules.service;

import com.rhpm.testapp.modules.model.posts.Post;
import com.rhpm.testapp.modules.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost () {
        return postRepository.findAll();
    }

    public Post createPost (Post post) {
        return postRepository.save(post);
    }
}
