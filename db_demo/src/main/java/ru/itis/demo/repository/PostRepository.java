package ru.itis.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.demo.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByUserContaining(String user, Pageable pageable);
}
