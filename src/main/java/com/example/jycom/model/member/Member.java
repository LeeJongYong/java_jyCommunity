package com.example.jycom.model.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String grade;
    private int point;

}
