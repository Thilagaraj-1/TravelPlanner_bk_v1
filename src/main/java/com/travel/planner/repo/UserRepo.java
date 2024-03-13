package com.travel.planner.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.planner.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	boolean existsByUsername(String username);
	Optional<User> findByUsernameAndPassword(String username,String password);
}
