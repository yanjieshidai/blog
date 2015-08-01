package com.yanjie.project.blog.web;

import com.yanjie.project.blog.bean.AjaxResult;
import com.yanjie.project.blog.bean.vo.UserVO;
import com.yanjie.project.blog.service.IUserService;
import com.yanjie.project.blog.util.UserUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015-07-31.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @Resource
    private IUserService userService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        return mv;
    }

    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(HttpServletResponse response, String login, String passwd) {
        AjaxResult result = new AjaxResult();
        UserVO userVO = userService.login(login, passwd);
        if (userVO == null) {
            result.setSuccess(false);
            result.setMessage("登录失败~");
            return result;
        }
        result.setSuccess(true);
        result.setData(userVO);
        result.setMessage("登录成功");
        UserUtil.addUserInfo(response, userVO);
        return result;
    }


    @RequestMapping("/logout")
    @ResponseBody
    public AjaxResult logout(HttpServletResponse response) {
        AjaxResult result = new AjaxResult();
        UserUtil.removeUserInfo(response);
        return result;
    }

}

