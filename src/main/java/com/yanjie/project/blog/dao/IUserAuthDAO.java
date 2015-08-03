package com.yanjie.project.blog.dao;

import com.yanjie.project.blog.bean.po.UserAuthPO;

import java.util.List;

/**
 * Description: UserAuthDAO
 * Author: wangjie12
 * Create: 2015-08-02
 */
public interface IUserAuthDAO {
    List<UserAuthPO> queryByUserId(Long id);

    int updateAuthInfoByUserId(Long userId, String info, short i);

    List<UserAuthPO> queryByUserId(Long userId, short i);

    UserAuthPO insert(UserAuthPO userAuthPO);
}
