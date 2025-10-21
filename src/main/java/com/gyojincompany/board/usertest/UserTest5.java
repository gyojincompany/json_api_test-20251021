package com.gyojincompany.board.usertest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gyojincompany.board.post.PostTest;

public class UserTest5 {
	
	private String username;	
	private String password;
	
	@JsonIgnore
	private List<PostTest> postTests;
}
