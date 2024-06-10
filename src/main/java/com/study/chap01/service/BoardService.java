package com.study.chap01.service;

import com.study.chap01.dto.BoardWriteRequestDto;
import com.study.chap01.entity.Board;
import com.study.chap01.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class BoardService {

    // mapper 의존
    private final BoardMapper boardMapper;

    // 삭제 요청 중간처리
    public boolean remove(int boardNo) {
        return boardMapper.delete(boardNo);
    }

    // 등록 요청 중간처리
    public boolean insert(BoardWriteRequestDto dto, HttpSession session) {
        Board b = dto.toEntity();

        return boardMapper.save(b);
    }



}
