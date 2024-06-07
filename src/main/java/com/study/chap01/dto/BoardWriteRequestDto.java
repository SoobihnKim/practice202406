package com.study.chap01.dto;

import com.study.chap01.entity.Board;
import lombok.*;

// dto 필드명은 반드시 html form 태그 name 속성과 일치해야함
@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BoardWriteRequestDto {

    private String writer;
    private String content;
    private String title;

    public Board toEntity() {
        Board b = new Board();
        b.setTitle(title);
        b.setContent(content);
        b.setAuthor(writer);
        return b;
    }
}
