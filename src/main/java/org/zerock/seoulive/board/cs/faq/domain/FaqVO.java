package org.zerock.seoulive.board.cs.faq.domain;


import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Value;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class FaqVO {
    private Integer rownum;
    private Integer seq;
    private String title;
    private String content;
    private String writer;
    private String category;
    private Timestamp writeDate;
    private Timestamp modifyDate;


    public FaqDTO toDTO(){
        FaqDTO dto = new FaqDTO();
        dto.setSeq(seq);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setWriter(writer);
        dto.setCategory(category);

        return dto;
    } // toDTO
} // end class
