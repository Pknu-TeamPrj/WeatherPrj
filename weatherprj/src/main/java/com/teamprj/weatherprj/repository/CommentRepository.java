package com.teamprj.weatherprj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamprj.weatherprj.entity.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    List<Comment> findByArea3(String area3);
}