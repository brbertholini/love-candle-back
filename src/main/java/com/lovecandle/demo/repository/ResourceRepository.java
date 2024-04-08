package com.lovecandle.demo.repository;

import com.lovecandle.demo.entitiy.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
