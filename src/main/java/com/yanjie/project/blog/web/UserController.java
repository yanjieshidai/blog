package com.yanjie.project.blog.web;

import com.yanjie.project.blog.bean.User;
import com.yanjie.project.blog.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangjie12 on 15-7-6.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{id}")
    @ResponseBody
    public User view(@PathVariable("id") Long id) {
        return null;
    }


}
