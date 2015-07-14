package com.yanjie.project.blog.service.impl;

import com.yanjie.project.blog.bean.convert.BlogConvert;
import com.yanjie.project.blog.bean.po.BlogPO;
import com.yanjie.project.blog.bean.vo.BlogVO;
import com.yanjie.project.blog.dao.IBlogDAO;
import com.yanjie.project.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description: BlogService
 * Author: wangjie12
 * Create: 2015-07-14
 */
@Component
public class BlogService implements IBlogService {

    @Autowired
    private IBlogDAO blogDAO;

    @Override
    public List<BlogVO> list() {
        List<BlogPO> blogPOList = blogDAO.list();
        List<BlogVO> blogVOList = BlogConvert.convertVOListFromPOList(blogPOList);
        return blogVOList;
    }
}
