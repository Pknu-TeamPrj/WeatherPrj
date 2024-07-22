package com.teamprj.weatherprj.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamprj.weatherprj.common.NotFoundException;
import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.entity.Reply;
import com.teamprj.weatherprj.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class ReplyService {
    private final ReplyRepository replyRepository;
    
    // return이 void -> Reply
    public Reply setReply(String content, Member writer){
        // 빌더를 사용한 방식
        Reply reply = Reply.builder().content(content).createDate(LocalDateTime.now()).build();
        log.info("댓글 객체 생성");
        reply.setWriter(writer);    // 작성자추가
        this.replyRepository.save(reply);
        log.info("댓글 객체 저장");

        return reply;
    }

    // 댓글 수정을 위해 댓글 가져오기
    public Reply getReply(Long rno){
        Optional<Reply> reply = this.replyRepository.findById(rno);
        if (reply.isPresent()){
            return reply.get();
        }else{
            throw new NotFoundException("Reply not found");
        }
    }

    // 댓글 수정처리
    public void modReply(Reply reply, String content){
        reply.setContent(content);
        reply.setModifyDate(LocalDateTime.now());

        this.replyRepository.save(reply);
    }

    // 댓글 삭제
    public void remReply(Reply reply){
        this.replyRepository.delete(reply);
    }

}