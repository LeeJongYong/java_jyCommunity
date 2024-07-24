package com.example.jycom.domain.member.controller;

import com.example.jycom.domain.member.domain.Member;
import com.example.jycom.domain.member.service.MemberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    private final MemberService memberService;

    private static final Logger log = LogManager.getLogger(MemberController.class);

    // 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        log.info("index 진입");
        return "content/board";
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
