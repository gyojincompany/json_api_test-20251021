package com.gyojincompany.board.dto;

import com.gyojincompany.board.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
	
	private Long id;
	private String username;
	
	public UserResponseDto(User user) { //User 엔티티를 Dto로 변환하는 생성자 
		this.id = user.getId();
		this.username = user.getUsername();
	}

}
