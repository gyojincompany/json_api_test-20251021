package com.gyojincompany.board.dto;

import com.gyojincompany.board.movie.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
	
	private Long id;
	private String title;
	
	public MovieResponseDto(Movie movie) {
		this.id = movie.getId();
		this.title = movie.getTitle();
	}
	
}
