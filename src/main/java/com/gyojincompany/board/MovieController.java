package com.gyojincompany.board;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyojincompany.board.dto.MovieCommentResponseDto;
import com.gyojincompany.board.dto.MovieResponseDto;
import com.gyojincompany.board.movie.MovieComment;
import com.gyojincompany.board.repository.MovieCommentRepository;
import com.gyojincompany.board.repository.UserRepository;

@RestController
public class MovieController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieCommentRepository movieCommentRepository;
	
	
	//순환참조 에러 발생 : movieComment->User->... StackOverflowError 발생
	@GetMapping("/movie_comments") //영화에 달린 코멘트들의 리스트를 반환 요청
	public List<MovieComment> getMoiveComments() {
		return movieCommentRepository.findAll(); //모든 코멘트들이 반환
	}
	
	//DTO를 활용한 순환참조 문제 해결
	@GetMapping("/movie_comments_ok")
	@Transactional(readOnly = true) //LAZY 관계 안전하게 조회->DB로딩 시점에서도 DB접근 가능
	public List<MovieCommentResponseDto> getMoiveCommentsOk() {
		return movieCommentRepository.findAll().stream() 
				//엔티티의 리스트를 자바 스트림으로 변환->map으로 변환 가능
				.map(MovieCommentResponseDto::new) //각 MovieComment 엔티티를 MovieCommentResponseDto로 변환(매핑)
				.collect(Collectors.toList());
	}
	
	
}
