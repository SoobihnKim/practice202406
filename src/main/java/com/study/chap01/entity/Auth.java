package com.study.chap01.entity;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public enum Auth {

    COMMON("일반회원", 1),
    ADMIN("관리자", 2);

    private String desc; // 권한 설명
    private int authNumber; // 권한 번호

}
