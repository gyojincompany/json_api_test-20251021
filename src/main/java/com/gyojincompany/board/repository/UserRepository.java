package com.gyojincompany.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.board.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
