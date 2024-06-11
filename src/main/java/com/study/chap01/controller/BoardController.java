package com.study.chap01.controller;

import com.study.chap01.dto.BoardDetailResponseDto;
import com.study.chap01.dto.BoardListResponseDto;
import com.study.chap01.dto.BoardWriteRequestDto;
import com.study.chap01.entity.Board;
import com.study.chap01.mapper.BoardMapper;
import com.study.chap01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    // 목록 조회 요청(/board/list : GET)
    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boardList = boardMapper.findAll();

        List<BoardListResponseDto> bList = new ArrayList<>();
        for (Board b : boardList) {
            BoardListResponseDto dto = new BoardListResponseDto(b);
            bList.add(dto);
        }
        model.addAttribute("bList", bList);

        return "board/list";
    }

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

    // 게시글 상세조회 요청(/board/detail : GET)
    @GetMapping("/detail")
    public String detail(int bno, Model model) {
        System.out.println("/board/detail GET!");
        System.out.println("bno = " + bno);

        Board b = boardMapper.findOne(bno);

        if(b != null) boardMapper.upViewCount(bno);

        model.addAttribute("bbb", new BoardDetailResponseDto(b));

        return "board/detail";
    }

    // 게시글 삭제(/board/delete: GET)
    @GetMapping("/delete")
    public String delete(int bno) {
        System.out.println("/board/delete GET!");

        boardMapper.delete(bno);

        return  "redirect:/board/list";
    }


}
