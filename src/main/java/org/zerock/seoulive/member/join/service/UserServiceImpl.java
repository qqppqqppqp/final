package org.zerock.seoulive.member.join.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.domain.UserVO;
import org.zerock.seoulive.member.join.exception.ServiceException;
import org.zerock.seoulive.member.join.mapper.UserMapper;

import java.util.Objects;


@Log4j2
@NoArgsConstructor

@Service("userService")
public class UserServiceImpl
        implements UserService, InitializingBean, DisposableBean {

    @Setter(onMethod_ = {@Autowired})
    private UserMapper dao;        // 영속성 계층의 DAO 빈 주입

    @Override
    public Boolean register(UserDTO dto) throws ServiceException {
        log.trace("register({}) invoked.", dto);

        try {
            return (this.dao.insert(dto) == 1);
        } catch(Exception e) {
            throw new ServiceException(e);
        } // try-catch
    } // register

    @Override
    public UserVO authenticate(UserDTO dto) throws ServiceException {
        log.trace("authenticate({}) invoked.", dto);

        try {
            return this.dao.selectUser(dto);
        } catch(Exception e) {
            throw new ServiceException(e);
        } // try-catch
    } // authenticate

    //    InitializingBean, DisposableBean    //
    @Override
    public void afterPropertiesSet() throws Exception {
        log.trace("afterPropertiesSet() invoked.");

//        assert this.dao != null;
        Objects.requireNonNull(this.dao);
        log.info("\t+ this.dao : {}", this.dao);
    } // afterPropertiesSet

    @Override
    public void destroy() throws Exception {
        log.trace("destroy() invoked.");

    } // destroy

} // end class
