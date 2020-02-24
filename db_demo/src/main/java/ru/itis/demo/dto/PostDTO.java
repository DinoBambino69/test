package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String user;
    private String text;

    public static PostDTO from(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .user(post.getUser())
                .text(post.getUser())
                .build();
    }

    public static List<PostDTO> from(List<Post> postList) {
        return postList.stream().map(PostDTO::from).collect(Collectors.toList());
    }
}