package com.yanjie.project.blog.bean.convert;

import com.yanjie.project.blog.bean.po.UserAuthPO;
import com.yanjie.project.blog.bean.po.UserPO;
import com.yanjie.project.blog.bean.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: BlogConvert
 * Author: wangjie12
 * Create: 2015-07-14
 */
public class UserConvert {
    public static UserVO convertVOFromPO(UserPO po) {
        if (po == null) {
            return null;
        }
        UserVO vo = new UserVO();
        vo.setUserPO(po);
        return vo;
    }

    public static List<UserVO> convertVOListFromPOList(List<UserPO> poList) {
        if (poList == null) {
            return null;
        }
        List<UserVO> userVOList = new ArrayList<>(poList.size());
        for (UserPO userPO : poList) {
            userVOList.add(convertVOFromPO(userPO));
        }
        return userVOList;
    }

    public static UserVO convertVOFromPOAndAuth(UserPO userPO, List<UserAuthPO> userAuthPOList) {
        UserVO userVO = convertVOFromPO(userPO);
        if (userVO == null) {
            return null;
        }
        userVO.setUserAuthList(UserAuthConvert.convertVOListFromPOList(userAuthPOList));
        return userVO;
    }
}
