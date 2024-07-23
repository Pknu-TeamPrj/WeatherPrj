package com.teamprj.weatherprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamprj.weatherprj.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}