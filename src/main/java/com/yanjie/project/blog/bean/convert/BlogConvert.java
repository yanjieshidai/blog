package com.yanjie.project.blog.bean.convert;

import com.yanjie.project.blog.bean.po.BlogPO;
import com.yanjie.project.blog.bean.vo.BlogVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: BlogConvert
 * Author: wangjie12
 * Create: 2015-07-14
 */
public class BlogConvert {
    public static BlogVO convertVOFromPO(BlogPO po) {
        if (po == null) {
            return null;
        }
        BlogVO vo = new BlogVO();
        vo.setBlogPO(po);
        return vo;
    }

    public static List<BlogVO> convertVOListFromPOList(List<BlogPO> poList) {
        if (poList == null) {
            return null;
        }
        List<BlogVO> blogVOList = new ArrayList<>(poList.size());
        for (BlogPO blogPO : poList) {
            blogVOList.add(convertVOFromPO(blogPO));
        }
        return blogVOList;
    }
}
