package com.gyojincompany.board.usertest;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTest1 {
	
	private String username;
	
	@JsonIgnore
	//해당 객체의 값이 Json으로 변환되어 반환될 때 password 필드는 Json에 포함되지 않음->password 반환 x
	private String password;
}
