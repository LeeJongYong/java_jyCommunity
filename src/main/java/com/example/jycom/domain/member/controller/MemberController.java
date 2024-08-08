package com.example.jycom.domain.member.controller;

import com.example.jycom.domain.board.service.BoardService;
import com.example.jycom.domain.member.domain.Member;
import com.example.jycom.domain.member.service.MemberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jycom/member")
public class MemberController {

    private final MemberService memberService;
    private final BoardService boardService;

    private static final Logger log = LogManager.getLogger(MemberController.class);

    // 생성자 주입
    @Autowired
    public MemberController(MemberService memberService, BoardService boardService) {
        this.memberService = memberService;
        this.boardService = boardService;
    }

    // 로그인 화면 호출
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn(Model model){
        log.info("singIn 화면 진입");
        model.addAttribute("member", new Member());
        return "member/signIn";
    }

    // 로그인
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(Model model, @ModelAttribute("member")Member member, @PageableDefault Pageable pageable){
        log.info("singIn 화면 실행");
        memberService.signIn(model, member);
        boardService.boardAll(model, pageable);
        return "content/board";
    }

    // 회원가입 화면 호출
    @RequestMapping(value = "/signUp", method = RequestMethod.GET )
    public String signUp(Model model){
        log.info("signUp 화면 진입");
        model.addAttribute("member", new Member());
        return "member/signUp";
    }

    // 회원가입
    @RequestMapping(value = "/signUp", method = RequestMethod.POST )
    public String signUp(Model model, @ModelAttribute("member")Member member){
        log.info("signUp 실행");
        memberService.singUp(model, member);
        return "member/signIn";
    }

    @RequestMapping(value = "/myPage", method = RequestMethod.GET)
    public String myPage(Model model, @RequestParam("email") String email){
        log.info("myPage 화면 진입");
        memberService.myInfo(model, email);
        return "member/myPage";
    }

}
