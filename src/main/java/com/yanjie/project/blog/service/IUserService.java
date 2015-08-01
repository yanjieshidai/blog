package com.yanjie.project.blog.service;

import com.yanjie.project.blog.bean.vo.UserVO;

/**
 * Description: IUserService
 * Author: wangjie12
 * Create: 2015-08-02
 */
public interface IUserService {
    UserVO login(String login, String passwd);
}
