package ru.itis.demo.service;

import org.springframework.data.domain.Page;
import ru.itis.demo.dto.PostDTO;
import ru.itis.demo.entity.Post;

public interface PostService {
    public void addPost(PostDTO postDTO);

}
