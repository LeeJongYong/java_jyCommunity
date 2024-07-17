package com.example.jycom.repository.member;

import com.example.jycom.model.member.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(String memberId);

}
