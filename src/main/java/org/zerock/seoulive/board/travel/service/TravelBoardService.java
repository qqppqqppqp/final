package org.zerock.seoulive.board.travel.service;

import org.zerock.seoulive.board.travel.domain.Criteria;
import org.zerock.seoulive.board.travel.domain.TravelBoardDTO;
import org.zerock.seoulive.board.travel.domain.TravelBoardVO;
import org.zerock.seoulive.exception.ServiceException;

import java.util.List;


public interface TravelBoardService {

    // 1. 게시판 목록 얻어 반환해주는 기능 수행
    public abstract List<TravelBoardVO> getList(Criteria cri) throws ServiceException;

    // 2. 새로운 게시물 등록 기능 수행(CREATE)
    public abstract Boolean register(TravelBoardDTO dto) throws ServiceException;

    // 3. 특정 게시물 상세조회(read)
    public abstract TravelBoardVO get(Integer seq) throws ServiceException;


    // 4. 특정 게시물 업데이트(update)
    public abstract Boolean modify(TravelBoardDTO dto) throws ServiceException;

    // 5. 특정 게시물 삭제(DELETE)
    public abstract Boolean remove(Integer writer) throws ServiceException;

    // 6. 총 게시물 개수 반환
    public abstract Integer getTotal(Criteria cri) throws ServiceException;

    List<TravelBoardVO> getListByDate(String selectedDate);

//    Integer getTotal() throws ServiceException;
} // end interface
