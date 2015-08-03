package com.yanjie.project.blog.service;

import com.yanjie.project.blog.bean.result.AjaxResult;
import com.yanjie.project.blog.bean.vo.UserVO;

/**
 * Description: IUserService
 * Author: wangjie12
 * Create: 2015-08-02
 */
public interface IUserService {
    UserVO login(String login, String passwd);

    AjaxResult<UserVO> info(Long id);

    AjaxResult authEvernote(Long userId, String info);

    AjaxResult authEvernoteInfo(Long userId);
}
