package com.teamprj.weatherprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamprj.weatherprj.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
    
}
