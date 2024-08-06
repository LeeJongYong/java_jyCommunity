package com.example.jycom.domain.member.dao;

import com.example.jycom.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, String> {
}
