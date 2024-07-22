package com.teamprj.weatherprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamprj.weatherprj.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{
    
}
