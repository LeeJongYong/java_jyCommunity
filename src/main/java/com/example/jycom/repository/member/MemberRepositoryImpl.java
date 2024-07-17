package com.example.jycom.repository.member;

import com.example.jycom.model.member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepositoryImpl implements MemberRepository {

    private static final Map<String, Member> memberStore = new HashMap<>();

    @Override
    public void save(Member member) {
        memberStore.put(member.getId(), member);
    }

    @Override
    public Member findById(String memberId) {
        return memberStore.get(memberId);
    }
}
