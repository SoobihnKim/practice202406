package com.study.chap01.mapper;

import com.study.chap01.entity.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    // 게시물 등록
    boolean save(Board board);

    // 게시물 삭제
    boolean delete(int boardNo);

    // 게시물 목록조회

    // 게시물 상세조회



}
