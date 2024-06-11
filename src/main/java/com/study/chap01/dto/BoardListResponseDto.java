package com.study.chap01.dto;

import com.study.chap01.entity.Board;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 서버에서 조회한 데이터 중 화면에 필요한 데이터만 모아놓은 클래스
// 나중에 자바스크립트 객체로 변환(클라이언트와 소통해야함)
@Getter
public class BoardListResponseDto {

    private int bno;
    private String shortTitle;
    private String shortContent;
    private String date;
    private int view;

    // 엔터티를 DTO로 변환하는 생성자
    public BoardListResponseDto(Board b) {
        this.bno = b.getBoardNo();
        this.shortTitle = makeShortTitle(b.getTitle());
        this.shortContent = makeShortContent(b.getContent());
        this.date = dateFormatting(b.getCreateTime());
        this.view = b.getViewCount();
    }

    private String dateFormatting(LocalDateTime createTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(createTime);
    }

    private String makeShortContent(String content) {
        return (content.length() > 5) ? content.substring(0, 30) + "..." : content;
    }

    private String makeShortTitle(String title) {
        return (title.length() > 5) ? title.substring(0, 5) + "...": title;
    }

}
