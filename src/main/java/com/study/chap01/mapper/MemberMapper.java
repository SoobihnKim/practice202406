package com.study.chap01.mapper;

import com.study.chap01.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    // 회원 가입
    boolean save(Member member);

    // 회원정보 개별 조회
    Member findOne(String account);

    // 중복 확인(아이디, 이메일)
    boolean existsById(@Param("type") String type,
                       @Param("keyword") String keyword);


}
