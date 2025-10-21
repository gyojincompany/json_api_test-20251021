package com.gyojincompany.board.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gyojincompany.board.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	//@JsonIgnore //User 필드는 JSON으로 변환될 때 제외시켜 달라!
	//@JsonBackReference
	//@JsonManagedReference
	//MovieComment는 User를 호출하지 않음
	private User user;
	
	// N:1 관계 -> 댓글 여러개:영화 1개
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	//@JsonIgnore //Movie 필드는 JSON으로 변환될 때 제외시켜 달라!
	//@JsonBackReference //MoiveComment->Movie로 호출하지 않음
	//@JsonManagedReference
	private Movie movie;

}
