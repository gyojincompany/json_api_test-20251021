package com.gyojincompany.board.movie;

import com.gyojincompany.board.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MovieComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;	
	
	// N:1 관계 -> 댓글 여러개:유저 1명
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	// N:1 관계 -> 댓글 여러개:영화 1개
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

}
