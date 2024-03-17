package com.example.community.controller;


import com.example.community.entity.Member;
import com.example.community.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
@RequestMapping("/web")
public class MemberController {


    @Autowired
    private MemberRepository memberRepository;

    
    
    @GetMapping("/main")
    public void mainpage(){
        log.info("메인페이지 들어옴");
    }


    @GetMapping("/memberlist")
    public void listGet(Model model){
        log.info("멤버 list 겟방식 들어옴");

        List<Member> members = memberRepository.memSelectAll();
        model.addAttribute("members",members);
    }

    @PostMapping("/memberlist")
    public void listPost(){
        log.info("멤버 list 포스트방식 들어옴");
    }




    @GetMapping("/memberregister")
    public void registerGet(){
        log.info("멤버 register 겟방식 들어옴");
    }

    @PostMapping("/memberregister")
    public void registerPost(String id,String pw,String name,String address,String birthdate,Model model,Member member){
        log.info("멤버 register 포스트방식 들어옴");
        member = Member.builder().id(id).pw(pw).name(name).address(address).birthdate(birthdate).build();
        memberRepository.save(member);
    }




    @GetMapping("/memberview")
    public void viewGet(Model model,Long mno){
        log.info("멤버 view 겟방식 들어옴");

        Optional<Member> member = memberRepository.memSelectOne(mno);
        Member member1 = member.orElseThrow();
        model.addAttribute("member",member1);
    }

    @PostMapping("/memberview")
    public void viewPost(Model model){
        log.info("멤버 view 포스트방식 들어옴");
    }




    @GetMapping("/membermodify")
    public void modifyGet(Model model,Long mno){
        log.info("멤버 list 겟방식 들어옴");

        Optional<Member> member = memberRepository.memSelectOne(mno);
        Member member1 = member.orElseThrow();
        model.addAttribute("member",member1);
    }

    @PostMapping("/membermodify")
    public String modifyPost(Long mno, String pw, String name, String birthdate, String address){
        log.info("멤버 list 포스트방식 들어옴");

        memberRepository.memModify(mno,pw,name,address,birthdate);

        return "redirect:/web/memberlist";

    }





    @GetMapping("/memberdelete")
    public String deleteGet(Long mno){
        log.info("멤버 delete 겟방식 들어옴");
        memberRepository.memDelete(mno);

        return "redirect:/web/memberlist";
    }

    @PostMapping("/memberdelete")
    public void deletePost(Model model){
        log.info("멤버 delete 포스트방식 들어옴");
    }


}
