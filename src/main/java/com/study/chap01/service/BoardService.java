package com.study.chap01.service;

import com.study.chap01.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    // mapper 의존
    private final BoardMapper boardMapper;



}
