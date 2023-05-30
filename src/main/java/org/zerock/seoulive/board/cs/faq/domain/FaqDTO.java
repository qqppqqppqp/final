package org.zerock.seoulive.board.cs.faq.domain;


import lombok.Data;

import java.util.Date;

@Data
public class FaqDTO {
    private Integer seq;
    private String title;
    private String content;
    private String writer;
    private String category;

}
