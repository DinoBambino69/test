package ru.itis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.dto.PostDTO;
import ru.itis.demo.entity.Post;
import ru.itis.demo.repository.PostRepository;
import ru.itis.demo.service.PostService;
import ru.itis.demo.service.PostServiceImpl;

import java.util.List;


@Controller
public class PostController {
    private PostService postService;
    PostServiceImpl postServiceImpl;
    PostRepository postRepository;

    @Autowired
    public PostController(PostService postService, PostRepository postRepository, PostServiceImpl postServiceImpl) {
        this.postService = postService;
        this.postRepository = postRepository;
        this.postServiceImpl = postServiceImpl;
    }

    @GetMapping("/search")
    public String searchByUser(Model model, @RequestParam(defaultValue = "1", required = false) Integer page,@RequestParam(name = "user") String name) {
        model.addAttribute("notes", postServiceImpl.find(name, page));
        return "posts";
    }

    @GetMapping("/posts")
    public String showAll( @RequestParam(defaultValue = "1", required = false) int page, Model model) {

        int pages = (int) Math.ceil((double) postRepository.findAll().size() / 5);
        if (pages == page) {
            model.addAttribute("pages", pages);
            model.addAttribute("notes", postRepository.findAll().subList(page * 5 - 5, postRepository.findAll().size()));
        } else if (pages > page && page > 0) {
            model.addAttribute("pages", pages);
            model.addAttribute("notes", postRepository.findAll().subList(page * 5 - 5, page * 5));
        } else {
            model.addAttribute("pages", 1);
            model.addAttribute("notes", postRepository.findAll().subList(0, 5));
        }

        return "posts";
    }


    @GetMapping("/add/post")
    public String addPost() {
        return "add-post";
    }

    @PostMapping("/add/post")
    public String addPost(PostDTO postDTO) {
        postService.addPost(postDTO);
        return "redirect:/posts";
    }
}
