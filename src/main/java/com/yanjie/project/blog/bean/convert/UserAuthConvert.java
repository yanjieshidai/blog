package com.yanjie.project.blog.bean.convert;

import com.yanjie.project.blog.bean.po.UserAuthPO;
import com.yanjie.project.blog.bean.po.UserPO;
import com.yanjie.project.blog.bean.vo.UserAuthVO;
import com.yanjie.project.blog.bean.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: BlogConvert
 * Author: wangjie12
 * Create: 2015-07-14
 */
public class UserAuthConvert {
    public static UserAuthVO convertVOFromPO(UserAuthPO po) {
        if (po == null) {
            return null;
        }
        UserAuthVO vo = new UserAuthVO();
        vo.setUserAuthPO(po);
        return vo;
    }

    public static List<UserAuthVO> convertVOListFromPOList(List<UserAuthPO> poList) {
        if (poList == null) {
            return null;
        }
        List<UserAuthVO> voList = new ArrayList<>(poList.size());
        for (UserAuthPO po : poList) {
            voList.add(convertVOFromPO(po));
        }
        return voList;
    }

}
