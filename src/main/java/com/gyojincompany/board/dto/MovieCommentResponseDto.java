package com.gyojincompany.board.dto;

import com.gyojincompany.board.movie.MovieComment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieCommentResponseDto {
	
	private Long id;
	private String content;
	private UserResponseDto user;
	private MovieResponseDto movie;
	
	public MovieCommentResponseDto(MovieComment movieComment) {
		this.id = movieComment.getId();
		this.content = movieComment.getContent();
		this.user = new UserResponseDto(movieComment.getUser());
		this.movie = new MovieResponseDto(movieComment.getMovie());		
	}
}
