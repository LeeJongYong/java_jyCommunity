package com.example.jycom.global.common;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ComDTO {

    // 등록일
    @Column
    LocalDateTime createdDt;

    // 수정일
    @Column
    LocalDateTime updatedDt;

}
