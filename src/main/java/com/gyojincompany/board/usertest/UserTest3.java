package com.gyojincompany.board.usertest;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
//Json으로 변환될 때, null값을 가진 필드는 제외하고 변환해서 반환해라!
public class UserTest3 {
	
	private String username;
	private String password;

}
