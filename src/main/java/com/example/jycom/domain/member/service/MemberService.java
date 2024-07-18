package com.example.jycom.domain.member.service;

import com.example.jycom.domain.member.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    // 회원가입
    public int singUp(Member member) {

        return 1;

    }

    // 로그인
    public Member signIn(Member member) {

        return member;

    }


}
