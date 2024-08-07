package com.example.jycom.domain.member.domain;

import com.example.jycom.global.common.ComDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Member extends ComDTO {

    @Id
    String id;
    @Column
    String name;
    @Column
    String password;
    @Column
    String email;
    @Column
    String phone;
    @Column
    String grade;
    @Column
    int point;

}
