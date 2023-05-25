package org.zerock.seoulive.mypage.service;

import java.util.List;

import org.zerock.seoulive.board.course.domain.CourseVO;

import org.zerock.seoulive.board.review.domain.ReviewBoardVO;

import org.zerock.seoulive.mypage.domain.Criteria;
import org.zerock.seoulive.mypage.domain.tbl_followerVO;
import org.zerock.seoulive.mypage.domain.tbl_likeVO;
import org.zerock.seoulive.mypage.exception.ServiceException;

public interface MyPageBoardService {
	
	// 찜목록 확인하기	list 리뷰 getList // Criteria cri
	public abstract List<ReviewBoardVO> getMyReviewList(String email,Criteria cri) throws ServiceException;
	// 찜목록 중 게시물 상세조회 read
	public abstract ReviewBoardVO getMyReview(Integer seq) throws ServiceException;
	// 자신의 리뷰 확인하기 list
	public abstract List<tbl_likeVO> getMyLikeList(String email,Criteria cri) throws ServiceException;
	// 자신의 리뷰들 중 상세조회 read
	public abstract tbl_likeVO getMyLike(Integer seq) throws ServiceException;
	
	// 6. 총 게시물 개수 반환
	public abstract Integer getMyPageReviewTotal(String email) throws ServiceException;
		
	
	// 자신이 작성한 코스들 확인하기 list
	public abstract List<CourseVO> getMyCourseList(Criteria cri) throws ServiceException;
	// 자신이 작성한 코스들 중 상세 조회 read
	public abstract ReviewBoardVO getMyCourse(Integer seq) throws ServiceException;
	// 팔로워 확인하기 
	public abstract List<tbl_followerVO> getFollowerList(Criteria cri) throws ServiceException;
	
}	// end interface
