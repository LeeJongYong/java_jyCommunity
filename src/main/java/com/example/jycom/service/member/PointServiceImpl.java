package com.example.jycom.service.member;

import com.example.jycom.model.member.Member;

public class PointServiceImpl implements PointService {
    @Override
    public int addPoint(Member member, int point) {
        return member.getPoint() + point;
    }

    @Override
    public int removePoint(Member member, int point) {

        int resPoint = member.getPoint() - point;

        if (resPoint <= 0) {
            resPoint = 0;
        }

        return resPoint;
    }
}
