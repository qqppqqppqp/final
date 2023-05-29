package org.zerock.seoulive.board.course.domain;

import lombok.Value;

import java.sql.Timestamp;
import java.util.Date;

@Value
public class memberDTO {
    public String EMAIL;
    public String PASSWORD;
    public String NICKNAME;
    public String BIRTH_DATE;
    public String GENDER;
    public String INTRODUCTION;
    public Date JOIN_DATE;
    public String PROFILE_IMG;
    public String REMEMBERME;
    public Timestamp REMEMBERMEAGE;
}
