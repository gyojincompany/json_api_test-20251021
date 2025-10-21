package com.gyojincompany.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.board.movie.MovieComment;

public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {

}
