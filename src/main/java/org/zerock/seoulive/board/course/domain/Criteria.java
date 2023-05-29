package org.zerock.seoulive.board.course.domain;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class Criteria {
    private Integer currPage = 1; //현재 페이지 번호
    private Integer page;
    private Integer amount = 10; //한 페이지당 게시물

//    For Pagination
    private Integer PagesPerPAge = 10; //한 페이지당 보여줄 페이지 목록의 길이

    public Criteria(Integer page, String board_name) {
        this.page = page;
    }
} //end class
