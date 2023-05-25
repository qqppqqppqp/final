package org.zerock.seoulive.board.course.persistence;

import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.memberVO;

@Repository
public interface memberDAO {

    public void withdrawal(memberVO vo) throws Exception;
}
