package com.yanjie.project.blog.dao;

import com.yanjie.project.blog.bean.po.UserPO;

/**
 * Description: IUserDAO
 * Author: wangjie12
 * Create: 2015-08-02
 */
public interface IUserDAO {
    UserPO queryByLogin(String login, String passwd);

    UserPO queryById(Long id);
}
