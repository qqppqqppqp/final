package org.zerock.seoulive.board.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zerock.seoulive.board.course.domain.Criteria;
import org.zerock.seoulive.board.course.domain.commVO;

import java.util.List;

@Mapper
public interface commentMapper {

    public Integer commRegit(commVO vo);
    public List<commVO> commList(Integer seq); //목록
    public Integer commTotal(Integer seq); //개수

    public Integer commDelete(Integer seq);

    public Integer commUpdate(commVO content);

    public List<commVO> getListWithPaging(
            @Param("cri") Criteria cri,
            @Param("board_name") String board_name
    );
}
