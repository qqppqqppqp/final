package org.zerock.seoulive.mypage.domain;

import java.util.Date;

import lombok.Data;

@Data
public class UserLikeDTO {
	private Integer seq;
	private String title;
	private String board;
	private Date write_Date;
}	// end class
