package com.study.chap01.entity;

import lombok.*;

import java.time.LocalDate;

@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private String account;
    private String password;
    private String name;
    private String email;
    private Auth auth;
    private LocalDate regDate;

}
