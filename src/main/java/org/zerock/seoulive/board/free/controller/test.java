package org.zerock.seoulive.board.free.controller;

public class test {
    public static void main(String[] args) {


        for (int i = 100; i <= 200; i++) {
            System.out.println("INSERT INTO tbl_free (seq, writer, category, title, content, write_date, modify_date, total_count)\n" +
                    "VALUES ("+i+", '이동영짱"+i+"', '카테고리', '공지사항', '공지사항 입니다.', TO_DATE('2023-05-11', 'YYYY-MM-DD'), null, 0);");
        }

//        for (int i = 6; i <= 10; i++) {
//            System.out.println("INSERT INTO tbl_comment (seq,writer,content,write_date,modify_date,board_name,post_seq)\n" +
//                    "VALUES ("+i+",'관리자','테스트공지사항',sysdate,null,'review',4);");
//        }
    }
}


