package org.zerock.seoulive.mypage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.seoulive.board.review.domain.ReviewBoardVO;
import org.zerock.seoulive.myapge.domain.Criteria;
import org.zerock.seoulive.myapge.domain.tbl_likeVO;

public interface MyPageBoardMapper {
	
	// 1. 과연 게시판 목록조회, C/R/U/D/LIST 에 필요한 메소드는 무엇일까!?	
//		@Select("""
//				SELECT /*+ index_desc(tbl_review) */ *
//				FROM tbl_review
//				OFFSET ( #{currPage} - 1) * #{amount} ROWS
//				FETCH NEXT #{amount} ROWS ONLY
//				""")
		
		@Select("""
				select 
				       		r.seq as review_seq,
				       		m.nickname as writer,
				        	r.title as review_title,
				        	r.content as review_content,
				        	r.total as review_total,
				        	r.write_date as review_write_date,
				        	r.modify_date as review_modify_date,
				        	r.place as review_place
				    	from
				        	tbl_member m, tbl_review r
				    	where
				        	m.nickname = r.writer
                            AND
                            m.email = #{email}
				""")
		public abstract List<ReviewBoardVO> selectLikeReviewList(String email,Criteria cri);

		
		public abstract ReviewBoardVO selectReview(Integer seq);
		public abstract List<tbl_likeVO> selectLikeList(String email,Criteria cri);
		
		// 마이페이지 나의 리뷰 게시물 페이징 처리를 위한 총 게시물 개수를 반환
		@Select("""
				SELECT 
					count(seq)
				FROM
					tbl_member m, tbl_like l
				WHERE
					m.email = l.email
					AND
					l.board = 'tbl_review'
					AND
					m.email = #{email}
				""")
		public abstract Integer getMyPageReviewTotal(String email);
		
}	// end interface
