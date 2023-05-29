package org.zerock.seoulive.mypage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.review.domain.ReviewBoardVO;
import org.zerock.seoulive.board.travel.domain.TravelBoardVO;
import org.zerock.seoulive.mypage.domain.Criteria;
import org.zerock.seoulive.mypage.domain.UserLikeVO;
import org.zerock.seoulive.mypage.domain.tbl_likeVO;

public interface MyPageBoardMapper {
	

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
		
		@Select("""
				SELECT * 
				FROM (
					SELECT t.seq , t.title, 'tbl_travel' as board,t.write_date FROM tbl_travel t WHERE t.seq in (
						select l.board_seq from tbl_member m, tbl_like l 
						where m.email = l.email and m.email = #{email} and l.board = 'travel')
					UNION
					SELECT r.seq, r.title, 'tbl_review' as board,r.write_date FROM tbl_review r WHERE seq in (
						select l.board_seq from tbl_member m, tbl_like l 
						where m.email = l.email and m.email = #{email} and l.board = 'review')
					UNION
					SELECT c.seq , c.title, 'tbl_course' as board,c.write_date FROM tbl_course c WHERE seq in (
						select l.board_seq from tbl_member m, tbl_like l 
						where m.email = l.email and m.email = #{email} and l.board = 'course')
					) o 
				ORDER BY o.write_date desc
				""")
		public abstract List<UserLikeVO> selectUserLikeList(String email); 
		
		public abstract List<tbl_likeVO> selectLikeList(String email,Criteria cri);
		
		// 마이페이지 나의 리뷰 게시물 페이징 처리를 위한 총 게시물 개수를 반환
		@Select("""
				SELECT count(seq)
				FROM tbl_member m, tbl_like l
				WHERE
					m.email = l.email
					AND
					l.board = 'tbl_review'
					AND
					m.email = #{email}
				""")
		public abstract Integer getMyPageReviewTotal(String email);
		
		
		@Select("""
				select t.* FROM tbl_member m , tbl_travel t
				WHERE m.nickname = t.writer AND m.email = #{email}
				""")
		public abstract List<TravelBoardVO> getMyTravelList(String email);
		
		@Select("Select * FROM tbl_travel where seq = #{seq}")
		public abstract TravelBoardVO getMyTravelBoard(Integer seq);
		
		@Select("""
				SELECT c.* FROM tbl_member m, tbl_course c
				WHERE m.nickname = c.writer AND m.email = #{email}
				""")
		public abstract List<CourseVO> getMyCourseList(String email);
		
		@Select("Select * FROM tbl_course where seq = #{seq}")
		public abstract CourseVO getMyCourse(Integer seq);
		
}	// end interface
