package com.yanjie.project.blog.dao;

import com.yanjie.project.blog.bean.po.BlogPO;

import java.util.List;

/**
 * Description: IBlogDAO
 * Author: wangjie12
 * Create: 2015-07-14
 */
public interface IBlogDAO {
    BlogPO queryById(Long id);

    List<BlogPO> queryAll();
}
