package com.lovecandle.demo.repository;

import com.lovecandle.demo.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
