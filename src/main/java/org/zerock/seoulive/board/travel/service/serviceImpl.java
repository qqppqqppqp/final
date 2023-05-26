package org.zerock.seoulive.board.travel.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.travel.domain.DTO;
import org.zerock.seoulive.board.travel.domain.VO;
import org.zerock.seoulive.board.travel.mapper.mapper;
import org.zerock.seoulive.exception.ServiceException;

import java.util.List;

@Log4j2
@NoArgsConstructor
@Service("service")
public class serviceImpl implements service {

    @Setter(onMethod_ ={@Autowired})
    private mapper dao;

    @Override
    public List<VO> getList() throws ServiceException {
        try {
            return this.dao.selectList();
        }
        catch(Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Boolean register(DTO dto) throws ServiceException {
        log.info("register({}) inoked.", dto);
        try {
            return this.dao.insert(dto) == 1;
        }
        catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public VO get(Integer seq) throws ServiceException {
        try {
            return this.dao.select(seq);
        }
        catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Boolean modify(DTO dto) throws ServiceException {
        try {
            return this.dao.update(dto) == 1;

        }
        catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Boolean remove(Integer seq) throws ServiceException {
            log.info("remove({}) invoked.", seq);
        try {
            return this.dao.delete(seq) == 1;
        }
        catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
