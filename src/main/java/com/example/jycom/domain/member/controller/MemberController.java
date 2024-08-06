package com.example.jycom.domain.member.controller;

import com.example.jycom.domain.member.domain.Member;
import com.example.jycom.domain.member.service.MemberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jycom/member")
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

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn(){
        return "member/signIn";
    }

    // 로그인
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(Model model, @ModelAttribute("member")Member member){
        memberService.signIn(model, member);
        return "content/board";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET )
    public String signUp(){
        return "member/signUp";
    }

    // 회원가입
    @RequestMapping(value = "/signUp", method = RequestMethod.POST )
    public String signUp(Model model, @ModelAttribute("member")Member member){
        memberService.singUp(model, member);
        return "member/signIn";
    }

}
