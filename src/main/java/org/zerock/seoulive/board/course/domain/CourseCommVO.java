package org.zerock.seoulive.board.course.domain;

import java.util.Date;

import lombok.Value;

@Value
public class CourseCommVO {
	private String writer;
	private String content;
	private Date write_date;
}
