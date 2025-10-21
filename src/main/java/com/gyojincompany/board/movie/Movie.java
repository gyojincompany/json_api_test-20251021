package com.gyojincompany.board.movie;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title; //영화 제목
	
	//1:N 관계->영화1개:여러개의 영화댓글
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
//	@JsonIgnore
	//@JsonManagedReference //Movie->MovieComment
	//@JsonBackReference
	private List<MovieComment> movieComments;

}
