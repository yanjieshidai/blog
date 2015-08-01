package com.yanjie.project.blog.util;

import com.yanjie.project.blog.bean.vo.UserVO;
import com.yanjie.project.blog.contants.UserContants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: UserUtil
 * Author: wangjie12
 * Create: 2015-07-19
 */
public class UserUtil {
    public static Long getUserId(HttpServletRequest request) {
        String idStr = null;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            String name = cookies[i].getName();
            if (UserContants.CookiesUserName.equals(name)) {
                idStr = cookies[i].getValue();
            }
        }
        Long id = Long.parseLong(idStr);
        return id;
    }

    public static void addUserInfo(HttpServletResponse response, UserVO userVO) {
        Cookie cookie = new Cookie(UserContants.CookiesUserName, userVO.getUserPO().getId() + "");
        response.addCookie(cookie);
    }

    public static void removeUserInfo(HttpServletResponse response) {
        Cookie cookie = new Cookie(UserContants.CookiesUserName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
