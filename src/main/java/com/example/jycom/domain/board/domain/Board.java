package com.example.jycom.domain.board.domain;

import com.example.jycom.global.common.ComDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Board extends ComDTO {

    @Id
    // 글번호
    String id;
    // 제목
    @Column(nullable = false)
    String subject;
    // 내용
    @Column
    String content;
    // 작성자
    @Column(nullable = false)
    String author;


}
