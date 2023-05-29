package org.zerock.seoulive.board.course.service;

import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.Criteria;
import org.zerock.seoulive.board.course.domain.commVO;

import java.util.List;


public interface commService {
    public List<commVO> list(Criteria cri, String board_name) throws Exception;

    public Integer write(commVO vo) throws Exception; //등록

    public Integer modify(commVO vo) throws Exception; //수정

    public Integer delete(Integer seq) throws Exception; //삭제

    public int getTotal(int seq); //댓글 개수

//    List<commVO> getComList(String writer); 관리자용 회원 댓글 불러오기
}
