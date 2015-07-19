package com.yanjie.project.blog.service;

import com.yanjie.project.blog.bean.AjaxResult;
import com.yanjie.project.blog.bean.vo.BlogVO;
import com.yanjie.project.blog.bean.vo.DocVO;

import java.util.List;

/**
 * Description: IBlogService
 * Author: wangjie12
 * Create: 2015-07-14
 */
public interface IBlogService {
    List<BlogVO> list();

    AjaxResult<DocVO> createDoc(DocVO docVO);
}
