package ru.itis.demo.service;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.PostDTO;
import ru.itis.demo.entity.Post;
import ru.itis.demo.repository.PostRepository;

import java.util.List;

@Component
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(PostDTO postDTO) {
        Post post = postRepository.save(Post.builder()
            .user(postDTO.getUser())
            .text(postDTO.getText())
            .build());
        postDTO.setId(post.getId());
    }

    public List<Post> findByUserContaining(String user, int page) {
        System.out.println(postRepository.findAll().size());
        return postRepository.findAllByUserContaining("%" + user + "%", PageRequest.of(page, 5)).toList();
    }
}
