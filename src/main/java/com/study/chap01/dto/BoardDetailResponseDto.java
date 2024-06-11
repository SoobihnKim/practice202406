package com.study.chap01.dto;

import com.study.chap01.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class BoardDetailResponseDto {

    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private String regDateTime;

    public BoardDetailResponseDto(Board b) {
        this.boardNo = b.getBoardNo();
        this.title = b.getTitle();
        this.content = b.getContent();
        this.writer = b.getWriter();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분 ss초");
        this.regDateTime = pattern.format(b.getCreateTime());
    }

}
