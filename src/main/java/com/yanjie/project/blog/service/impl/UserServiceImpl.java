package com.yanjie.project.blog.service.impl;

import com.yanjie.project.blog.bean.convert.UserConvert;
import com.yanjie.project.blog.bean.po.UserPO;
import com.yanjie.project.blog.bean.vo.UserVO;
import com.yanjie.project.blog.dao.IUserDAO;
import com.yanjie.project.blog.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description: UserServiceImpl
 * Author: wangjie12
 * Create: 2015-08-02
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDAO userDAO;

    @Override
    public UserVO login(String login, String passwd) {
        UserPO userPO = userDAO.queryByLogin(login, passwd);
        UserVO vo = UserConvert.convertVOFromPO(userPO);
        return vo;
    }
}
