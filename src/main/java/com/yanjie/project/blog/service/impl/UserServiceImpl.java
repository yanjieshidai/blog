package com.yanjie.project.blog.service.impl;

import com.yanjie.project.blog.bean.convert.UserAuthConvert;
import com.yanjie.project.blog.bean.convert.UserConvert;
import com.yanjie.project.blog.bean.po.UserAuthPO;
import com.yanjie.project.blog.bean.po.UserPO;
import com.yanjie.project.blog.bean.result.AjaxResult;
import com.yanjie.project.blog.bean.vo.UserAuthVO;
import com.yanjie.project.blog.bean.vo.UserVO;
import com.yanjie.project.blog.contants.UserAuthContants;
import com.yanjie.project.blog.contants.UserContants;
import com.yanjie.project.blog.dao.IUserAuthDAO;
import com.yanjie.project.blog.dao.IUserDAO;
import com.yanjie.project.blog.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: UserServiceImpl
 * Author: wangjie12
 * Create: 2015-08-02
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDAO userDAO;

    @Resource
    private IUserAuthDAO userAuthDAO;

    @Override
    public UserVO login(String login, String passwd) {
        UserPO userPO = userDAO.queryByLogin(login, passwd);
        UserVO vo = UserConvert.convertVOFromPO(userPO);
        return vo;
    }

    @Override
    public AjaxResult<UserVO> info(Long id) {
        UserPO userPO = userDAO.queryById(id);
        List<UserAuthPO> userAuthPOList = userAuthDAO.queryByUserId(id);
        UserVO userVO = UserConvert.convertVOFromPOAndAuth(userPO, userAuthPOList);
        return new AjaxResult<>(true, userVO);
    }

    @Override
    public AjaxResult authEvernote(Long userId, String info) {
        List<UserAuthPO> userAuthPOs = userAuthDAO.queryByUserId(userId, UserAuthContants.AUTH_EVERNOTE_TYPE);
        if (userAuthPOs == null || userAuthPOs.isEmpty()) {
            UserAuthPO userAuthPO = new UserAuthPO(userId, UserAuthContants.AUTH_EVERNOTE_TYPE, info);
            userAuthPO = userAuthDAO.insert(userAuthPO);
            UserAuthVO vo = UserAuthConvert.convertVOFromPO(userAuthPO);
            return new AjaxResult(true, vo, "插入成功");
        }
        int len = userAuthDAO.updateAuthInfoByUserId(userId, info, UserAuthContants.AUTH_EVERNOTE_TYPE);
        if (len > 0) {
            AjaxResult result = authEvernoteInfo(userId);
            if (result.isSuccess()) {
                result.setMessage("更新成功！");
            } else {
                result.setMessage("更新失败");
            }
            return result;
        }
        return new AjaxResult(false, null, "更新失败！");
    }

    @Override
    public AjaxResult authEvernoteInfo(Long userId) {
        List<UserAuthPO> userAuthPOs = userAuthDAO.queryByUserId(userId, UserAuthContants.AUTH_EVERNOTE_TYPE);
        if (userAuthPOs != null && !userAuthPOs.isEmpty()) {
            return new AjaxResult(true, userAuthPOs.get(0), "成功");
        } else {
            return new AjaxResult(false, null, "没有找到结果");
        }
    }
}
