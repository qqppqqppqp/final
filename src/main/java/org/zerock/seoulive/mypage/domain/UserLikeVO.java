package org.zerock.seoulive.mypage.domain;

import java.util.Date;

import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Value
public class UserLikeVO {
	private Integer seq;
	private String title;
	private String board;
	private Date write_Date;
	
	public UserLikeDTO toDTO() {
		log.trace("\t toDTO() invoked.");
		UserLikeDTO dto = new UserLikeDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setBoard(board);
		dto.setWrite_Date(write_Date);
		log.info("\t dto : {} ",dto);
		return dto;
	}	// end method toDTO();
	
}	// end class
