package org.zerock.seoulive.board.travel.mapper;

import org.apache.ibatis.annotations.*;
import org.zerock.seoulive.board.travel.domain.DTO;
import org.zerock.seoulive.board.travel.domain.VO;

import java.util.List;

public interface Mapper {
    @Select("""
            SELECT * FROM TBL_TRAVEL
            """)
    public abstract List<VO> selectList();
    @Insert("""
            INSERT INTO TBL_TRAVEL (CATEGORY, TITLE, CONTENT, ADDRESS, START_TIME, END_TIME, START_DATE, END_DATE)
            VALUES (#{category}, #{title}, #{content}, #{address}, #{start_time}, #{end_time}, #{start_date}, #{end_date})
            """)
    public abstract Integer insert(DTO dto);
    @Select("""
            SELECT * FROM TBL_TRAVEL WHERE seq = #{seq}
            """)
    public abstract VO select(@Param("seq") Integer seq);
    @Delete("""
            DELETE FROM TBL_TRAVEL WHERE seq = #{seq}
            """)
    public abstract Integer delete(Integer seq);

    @Update("""
            UPDATE TBL_TRAVEL SET title = #{title}, content = #{content}, address = #{address}, modify_date = current_date,
                                          start_time = #{start_time}, end_time = #{end_time}, start_date = #{start_date}, end_date = #{end_date}
                              WHERE seq = #{seq}
            """)
    public abstract Integer update(DTO dto);


} // end interface
