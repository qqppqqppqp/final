package org.zerock.seoulive.board.course.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.Criteria;
import org.zerock.seoulive.board.course.domain.commVO;
import org.zerock.seoulive.board.course.mapper.commentMapper;

import java.util.List;
@Log4j2
@NoArgsConstructor
@Service
public class commServiceImpl implements commService{

    @Setter(onMethod_ = @Autowired)
    private commentMapper mapper;

    @Override
    public List<commVO> list(Criteria cri, String board_name) throws Exception {
        log.trace(" >>> list({}) invoked", board_name);

        return mapper.getListWithPaging(cri, board_name);
    }

    @Override
    public Integer write(commVO vo) throws Exception {
        log.info("write() invoked");

        return this.mapper.commRegit(vo);
    }

    @Override
    public Integer modify(commVO vo) throws Exception {
        log.info("modify() invoked");

        return this.mapper.commUpdate(vo);
    }

    @Override
    public Integer delete(Integer seq) throws Exception {
        log.info("delete() invoked");

        return this.mapper.commDelete(seq);
    }

    @Override
    public int getTotal(int seq) {
        return mapper.commTotal(seq);
    }
}
