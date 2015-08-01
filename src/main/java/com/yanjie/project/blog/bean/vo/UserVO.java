package com.yanjie.project.blog.bean.vo;

import com.yanjie.project.blog.bean.po.UserPO;

/**
 * Description: UserVO
 * Author: wangjie12
 * Create: 2015-08-02
 */
public class UserVO {
    public UserPO getUserPO() {
        return userPO;
    }

    public void setUserPO(UserPO userPO) {
        this.userPO = userPO;
    }

    private UserPO userPO;
}
