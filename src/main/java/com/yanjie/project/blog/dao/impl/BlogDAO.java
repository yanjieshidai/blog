package com.yanjie.project.blog.dao.impl;

import com.yanjie.project.blog.bean.po.BlogPO;
import com.yanjie.project.blog.dao.IBlogDAO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description: BlogDAO
 * Author: wangjie12
 * Create: 2015-07-14
 */
@Component
public class BlogDAO extends BaseDAO implements IBlogDAO {

    @Override
    public List<BlogPO> list() {
        List<BlogPO> blogs = jdbcTemplate.query("select * from t_blog limit 10",
                new Object[]{},
                (rs, rowNum) -> {
                    BlogPO blog = new BlogPO();
                    blog.setId(rs.getInt("id"));
                    blog.setTitle(rs.getString("title"));
                    return blog;
                });
        return blogs;
    }
}
