package com.yanjie.project.blog.dao;

import com.yanjie.project.blog.bean.po.DocPO;

import java.util.List;

/**
 * Description: IBlogDAO
 * Author: wangjie12
 * Create: 2015-07-14
 */
public interface IDocDAO {
    DocPO insert(DocPO docPO);

    List<DocPO> queryAll();

    DocPO queryById(Long id);
}
