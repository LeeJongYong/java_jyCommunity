package com.example.jycom.domain.member.domain;

import lombok.Getter;

@Getter
public enum ActPoint {
    WRITE(5),
    READ(3),
    COMMENT(1),
    ;

    private final int point;

    ActPoint(int point) {
        this.point = point;
    }
}
