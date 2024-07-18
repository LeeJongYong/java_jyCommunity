package com.example.jycom.global.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ComDTO {

    LocalDateTime createdDt;

    LocalDateTime updatedDt;

}
