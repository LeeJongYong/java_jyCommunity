package com.example.jycom.domain.member.controller;

import com.example.jycom.domain.member.domain.Member;
import com.example.jycom.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void signIn(){
        Member member = new Member();
        memberService.signIn(member);
    }

    public void signUp(){
        Member member = new Member();
        memberService.singUp(member);
    }

}
