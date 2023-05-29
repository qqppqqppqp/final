package org.zerock.seoulive.board.course.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.CourseDTO;
import org.zerock.seoulive.board.course.domain.CourseTravelDTO;
import org.zerock.seoulive.board.course.domain.CourseTravelVO;
import org.zerock.seoulive.board.course.domain.CourseVO;

import java.util.List;
@Mapper
public interface courseViewMapper {

//    @Select("select * from tbl_course where seq > 0")
    public List<CourseVO> getList();

    public List<CourseVO> read(Integer seq);

    public Integer delete(Integer seq);

    public Integer update(CourseDTO course);

//    =============== course_travel ===================

    public List<CourseTravelVO> courseTravelGetList(Integer seq);

    public Integer courseTravelDelete(Integer seq);

    public Integer CourseTravelUpdate(CourseTravelDTO courseTravel);



} //end interface
