package com.gyojincompany.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyojincompany.board.post.Post;
import com.gyojincompany.board.repository.PostRepository;
import com.gyojincompany.board.repository.UserRepository;
import com.gyojincompany.board.user.User;
import com.gyojincompany.board.usertest.UserTest;
import com.gyojincompany.board.usertest.UserTest1;
import com.gyojincompany.board.usertest.UserTest2;
import com.gyojincompany.board.usertest.UserTest3;
import com.gyojincompany.board.usertest.UserTest4;

@RestController
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/usertest")
	public UserTest usertest() {
		UserTest userTest = new UserTest();
		userTest.setUsername("tiger");
		userTest.setPassword("12345");
		return userTest;
	}
	
	@GetMapping("/usertest1") //@JsonIgnore 적용
	public UserTest1 usertest1() {
		UserTest1 userTest1 = new UserTest1();
		userTest1.setUsername("tiger");
		userTest1.setPassword("12345");
		return userTest1;
	}
	
	@GetMapping("/usertest2") //@JsonIgnoreProperties 적용
	public UserTest2 usertest2() {
		UserTest2 userTest2 = new UserTest2();
		userTest2.setUsername("tiger");
		userTest2.setPassword("12345");
		userTest2.setEmail("tiger@abc.com");
		return userTest2;
	}
	
	@GetMapping("/usertest3") //@JsonInclude 적용
	public UserTest3 usertest3() {
		UserTest3 userTest3 = new UserTest3();
		userTest3.setUsername("tiger");
//		userTest3.setPassword("12345"); ->password==null
		return userTest3;
	}
	
	@GetMapping("/usertest4") //@JsonProperty 적용
	public UserTest4 usertest4() {
		UserTest4 userTest4 = new UserTest4();
		userTest4.setUsername("tiger");
		userTest4.setPassword("12345");
		return userTest4;
	}
	
	//============== Entity 적용 ================	
	
	@GetMapping("/users") //모든 유저를 반환하는 요청 처리
	public List<User> getUsers() {
		return userRepository.findAll(); //모든 유저 반환
	}
	//순환참조 에러 발생 User->Post->User->Post... 무한루프 호출
	// User -> Post 리스트 직렬화
		// Post 안의 user 직렬화
	 		// 무한 반복
	
	//순환참조 에러 발생 Post->User->Post->User... 무한루프 호출
	@GetMapping("/posts") //모든 게시글을 반환하는 요청 처리
	public List<Post> getPosts() {
		return postRepository.findAll(); //모든 게시글 가져오기
	}
}
