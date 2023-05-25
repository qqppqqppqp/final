package org.zerock.seoulive.board.course.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.seoulive.board.course.domain.CourseCommVO;
import org.zerock.seoulive.board.course.domain.CourseDTO;
import org.zerock.seoulive.board.course.domain.CourseLikeDTO;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.domain.CourseTravelVO;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.domain.CourseWriteDTO;
import org.zerock.seoulive.board.course.domain.CourseWriteVO;
import org.zerock.seoulive.board.travel.domain.TravelBoardDTO;

public interface CourseDAO {
	
//	// 1. 과연 게시판 목록조회, C/R/U/D에 필요한 메소드는 무엇일까?
//	@Select("""
//			SELECT *
//			FROM tbl_course
//			OFFSET ( #{currPage} - 1) * #{amount} ROW
//			FETCH NEXT #{amount} ROWS ONLY
//			""")
//	public abstract List<CourseDTO> courseList(CoursePageTO page);
//	
//	// 2. 게시판 전체 목록 개수
//	@Select("SELECT count(seq) FROM tbl_course WHERE seq > 0")
//	public abstract int getTotalAmount();
	
	// 3. 게시물 당 가지고 있는 여행지 목록
	@Select("""
			SELECT ct.*, tt.CATEGORY, tt.TITLE, tt.CONTENT, tt.ADDRESS
			FROM TBL_COURSE_TRAVEL ct JOIN TBL_TRAVEL tt 
				ON ct.TRAVEL_SEQ = tt.seq
			WHERE BOARD_SEQ = ${seq}
			""")
	public abstract List<CourseTravelVO> selectTravelList(CourseDTO dto);
	@Select("""
			SELECT ct.*, tt.CATEGORY, tt.TITLE, tt.CONTENT, tt.ADDRESS
			FROM TBL_COURSE_TRAVEL ct JOIN TBL_TRAVEL tt 
				ON ct.TRAVEL_SEQ = tt.seq
			WHERE BOARD_SEQ = ${seq}
			""")
	public abstract List<CourseTravelVO> selectTravelList2(Integer seq);
	
	// 4. 검색 결과 리스트
	@Select("""
			SELECT *
			FROM tbl_course 
			WHERE ${searchType} LIKE '%' || #{keyword} || '%'
			ORDER BY seq DESC
			OFFSET ( #{currPage} - 1) * #{amount} ROW
			FETCH NEXT #{amount} ROWS ONLY
			""")
	public abstract List<CourseDTO> searchCourse(CoursePageTO page);
	
	// 5. 검색 후 리스트 개수
	@Select("""
			SELECT count(seq)
			FROM tbl_course 
			WHERE ${searchType} LIKE '%' || #{keyword} || '%'
			""")
	public abstract int getTotalSearch(String searchType, String keyword);
	
	// 6. 새로운 게시물 등록
	@Insert("""
			INSERT INTO tbl_course (WRITER, TITLE, REVIEW, DURATION_START, DURATION_END, TOTAL)
			VALUES (#{WRITER}, #{TITLE}, #{REVIEW}, #{DURATION_START}, #{DURATION_END}, 10)
			""")
	public abstract void insertCourse(CourseWriteDTO dto);
	@Insert("""
			INSERT INTO tbl_course_travel (BOARD_SEQ, TRAVEL_SEQ, USER_REVIEW)
			VALUES (COURSE_SEQ.CURRVAL, #{TRAVEL_SEQ}, #{USER_REVIEW})
			""")
	public abstract void insertCourseTravel(CourseWriteVO vo);
	
	// 7. 게시물 등록 중 여행지 검색
	@Select("""
			SELECT SEQ, CATEGORY, TITLE, ADDRESS
			FROM TBL_TRAVEL
			WHERE TITLE LIKE '%' || #{keyword} || '%'
			""")
	public abstract List<TravelBoardDTO> getTravelData(String keyword);
	
	// 8. 게시물 찜
	@Insert("""
			INSERT INTO tbl_like (EMAIL, BOARD_SEQ, BOARD)
			VALUES ('seoulive', #{BOARD_SEQ}, #{BOARD})
			""")
	public abstract void courseLike(CourseLikeDTO dto);
		
	// 9. 특정 게시물 상세조회
	public CourseVO read(Integer seq);
	
	// 10. 댓글 가져오기
	@Select("""
			SELECT writer, content, write_date
	        FROM tbl_comment
	        WHERE post_seq = #{seq}
	          AND board_name = 'course'
			""")
	public abstract List<CourseCommVO> commList(Integer seq);
	
	@Insert("""
			INSERT INTO tbl_comment (CONTENT, BOARD_NAME, POST_SEQ, WRITER)
			VALUES (#{content}, 'course', #{seq}, 'NICKNAME')
			""")
	public abstract void commRegister(String content, Integer seq);
	
	
	
//	// n. 특정 게시물 삭제
//	public Integer delete(Integer seq);
//	
//	// n. 특정 게시물 업데이트(갱신)
//	public Integer update(courseDTO course);

	
} // end interface
