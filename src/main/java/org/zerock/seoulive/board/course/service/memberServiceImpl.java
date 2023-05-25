package org.zerock.seoulive.board.course.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.memberVO;
import org.zerock.seoulive.board.course.mapper.commentMapper;
import org.zerock.seoulive.board.course.persistence.memberDAO;

@Service
public class memberServiceImpl implements memberService{

    @Setter(onMethod_ = @Autowired)
    private memberDAO dao;
    @Override
    public void withdrawal(memberVO vo) throws Exception {
        dao.withdrawal(vo);
    }
}
