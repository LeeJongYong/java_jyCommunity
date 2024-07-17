package com.example.jycom.service.member;

import com.example.jycom.model.member.Member;

public interface MemberService {

    void join(Member member);
    Member findMemberById(String memberId);

}
