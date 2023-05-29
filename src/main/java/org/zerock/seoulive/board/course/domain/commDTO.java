package org.zerock.seoulive.board.course.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class commDTO {
    private Integer SEQ;
    private String WRITER;
    private String CONTENT;
    private Date WRITE_DATE;
    private Date MODIFY_DATE;
    private String BOARD_NAME;
    private Integer POST_SEQ;


    public Integer getSeq() {
        return SEQ;
    }
    public String getWriter() {return WRITER;}
    public String getContent() {return CONTENT;}
    public Date getWrite_date() {return WRITE_DATE;}
    public Date getModify_date() {return MODIFY_DATE;}
    public String getBoard_name() {return BOARD_NAME;}
    public Integer getPost_seq() {return POST_SEQ;}

} //end class
