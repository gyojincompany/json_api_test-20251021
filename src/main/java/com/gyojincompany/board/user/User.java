package com.gyojincompany.board.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gyojincompany.board.movie.MovieComment;
import com.gyojincompany.board.post.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	//Post와 연관관계를 설정할때 post들의 주인이 누구냐를 설정
	//cascade = CascadeType.ALL->User를 저장하거나 삭제하면 Post도 함께 저장되거나 삭제됨
	//@JsonIgnore
	@JsonManagedReference
	private List<Post> posts;
	
	//1:N 관계 -> 유저 1명:영화댓글 여러개
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<MovieComment> movieComments;

}
