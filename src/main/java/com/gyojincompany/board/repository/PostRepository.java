package com.gyojincompany.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.board.post.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
