package com.example.jycom.domain.board.domain;

import com.example.jycom.global.common.ComDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Board extends ComDTO {

    // 글번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    // 제목
    @Column(nullable = false)
    String subject;
    // 내용
    @Column
    String content;
    // 작성자
    @Column(nullable = false)
    String userid;


}
