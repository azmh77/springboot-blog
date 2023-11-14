package com.rhpm.testapp.modules.service;

import com.rhpm.testapp.modules.model.posts.Post;
import com.rhpm.testapp.modules.repository.PostRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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

    @Transactional
    public Post createPost (Post post) throws IOException {

        String path = ResourceUtils.getFile("classpath:static/img/").getAbsolutePath();
        byte[] bytea = post.getFile().getBytes();
        Files.write(Paths.get(path + File.separator + UUID.randomUUID() + post.getFile().getOriginalFilename()), bytea);
        post.setCover(UUID.randomUUID() + post.getFile().getOriginalFilename());
        return postRepository.save(post);
    }
}
