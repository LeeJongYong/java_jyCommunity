package com.example.jycom.model.member;

import lombok.Getter;

enum memberGrade {
    FOOT,
    BODY,
    HEAD,
}

@Getter
enum actPoint {
    WRITE(5),
    READ(3),
    COMMENT(1),
    ;

    private final int point;

    actPoint(int point) {
        this.point = point;
    }

}