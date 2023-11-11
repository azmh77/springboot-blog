package com.rhpm.testapp.modules;

import com.rhpm.testapp.modules.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private PostService postService;

    @Autowired()
    public MainController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("posts" , postService.getAllPost());
        return "index";
    }

    @RequestMapping("/Login")
    public String login() {
        return "Login";
    }
}
