package com.example.jycom.service.member;

import com.example.jycom.model.member.Member;
import com.example.jycom.repository.member.MemberRepository;
import com.example.jycom.repository.member.MemberRepositoryImpl;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemberRepositoryImpl();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemberById(String memberId) {
        return memberRepository.findById(memberId);
    }
}
