package com.example.jycom.domain.member.service;

import com.example.jycom.domain.member.dao.MemberDao;
import com.example.jycom.domain.member.domain.Member;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class MemberService {

    private static final Logger logger = LogManager.getLogger(MemberService.class);

    private final MemberDao memberDao;

    @Autowired
    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    // 로그인
    public void signIn(Model model, Member member) {

        Member res = new Member();

        res = memberDao.findById(member.getId()).orElseThrow(NoSuchElementException::new);

        model.addAttribute("member", res);

    }

    // 회원가입
    public void singUp(Model model, Member member) {

        String res = "";

        if (memberDao.existsById(member.getEmail())) {
            res = "이미 가입된 회원입니다.";
        }
        else{
            member.setId(UUID.randomUUID().toString());
            memberDao.save(member);
            res = "회원가입을 축하합니다.";
        }

        model.addAttribute("member", res);

    }


}
