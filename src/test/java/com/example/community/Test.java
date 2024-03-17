package com.example.community;


import com.example.community.entity.Member;
import com.example.community.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class Test {

    @Autowired
    private MemberRepository memberRepository;


    @org.junit.jupiter.api.Test
    public void memregiTest(){
        Member member = Member.builder().id("asd123").pw("as33dasd").name("장구1").address("덕잎마을1").birthdate("1855").build();
        memberRepository.save(member);
    }
}
