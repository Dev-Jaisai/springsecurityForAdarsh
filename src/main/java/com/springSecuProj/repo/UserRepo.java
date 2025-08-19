package com.springSecuProj.repo;

import com.springSecuProj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {


    Optional<User> findByUsername(String username);
}
