package com.example.jycom.domain.member.domain;

import com.example.jycom.global.common.ComDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member extends ComDTO {

    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String grade;
    private int point;

}
