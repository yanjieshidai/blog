package com.yanjie.project.blog.bean.vo;

import com.yanjie.project.blog.bean.po.UserAuthPO;
import com.yanjie.project.blog.bean.po.UserPO;

import java.util.List;

/**
 * Description: UserVO
 * Author: wangjie12
 * Create: 2015-08-02
 */
public class UserVO {
    private UserPO userPO;
    private List<UserAuthVO> userAuthList;

    public UserPO getUserPO() {
        return userPO;
    }

    public void setUserPO(UserPO userPO) {
        this.userPO = userPO;
    }

    public List<UserAuthVO> getUserAuthList() {
        return userAuthList;
    }

    public void setUserAuthList(List<UserAuthVO> userAuthList) {
        this.userAuthList = userAuthList;
    }
}
