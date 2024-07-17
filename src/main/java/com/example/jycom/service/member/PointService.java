package com.example.jycom.service.member;

import com.example.jycom.model.member.Member;

public interface PointService {

    int addPoint(Member member, int point);
    int removePoint(Member member, int point);

}
