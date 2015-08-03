package com.yanjie.project.blog.web.admin;

import com.yanjie.project.blog.bean.result.AjaxResult;
import com.yanjie.project.blog.bean.vo.UserVO;
import com.yanjie.project.blog.service.IUserService;
import com.yanjie.project.blog.util.UserUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangjie12 on 15-7-6.
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping({"/", ""})
    @ResponseBody
    public AjaxResult<UserVO> info(HttpServletRequest request) {
        Long id = UserUtil.getUserId(request);
        if (id == null) {
            return new AjaxResult<>(false, null, "还没有登录");
        }
        AjaxResult<UserVO> result = userService.info(id);
        return result;
    }

    @RequestMapping("/auth/evernote")
    @ResponseBody
    public AjaxResult authEvernote(String info, HttpServletRequest request) {
        AjaxResult ajaxResult = new AjaxResult();
        Long userId = UserUtil.getUserId(request);
        ajaxResult = userService.authEvernote(userId, info);
        return ajaxResult;
    }

    @RequestMapping("/auth/evernote/info")
    @ResponseBody
    public AjaxResult authEvernoteInfo(HttpServletRequest request) {
        AjaxResult ajaxResult = new AjaxResult();
        Long userId = UserUtil.getUserId(request);
        ajaxResult = userService.authEvernoteInfo(userId);
        return ajaxResult;
    }
}
