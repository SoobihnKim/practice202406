package com.study.chap01.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private int viewCount;
    private LocalDateTime createTime;

}
