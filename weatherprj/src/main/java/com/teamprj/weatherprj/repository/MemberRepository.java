package com.teamprj.weatherprj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamprj.weatherprj.entity.Member;



@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
    Optional<Member> findByUserName(String userId);

    Optional<Member> findByUserId(String userId);
}
