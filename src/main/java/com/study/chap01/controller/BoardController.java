package com.study.chap01.controller;

import com.study.chap01.dto.BoardWriteRequestDto;
import com.study.chap01.entity.Board;
import com.study.chap01.mapper.BoardMapper;
import com.study.chap01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    // 게시글 쓰기 양식 화면 열기 요청(/board/write : GET)
    @GetMapping("/write")
    public String write() {
        System.out.println("/board/write GET!");
        return "board/write";
    }

    // 게시글 등록 요청((/board/write : POST)
    @GetMapping("/write")
    public String write(BoardWriteRequestDto dto) {
        System.out.println("/board/write POST!");
        System.out.println("dto = " + dto);

        Board b = dto.toEntity();
        boardMapper.save(b);

        return "board/";
    }


}
