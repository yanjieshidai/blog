package com.wj.project.test.web;

import com.wj.project.test.bean.User;
import com.wj.project.test.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangjie12 on 15-7-6.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhang");
        if (userBean == null) {
            user.setName("None");
        }
        return user;
    }

    @Autowired
    private UserBean userBean;
}
