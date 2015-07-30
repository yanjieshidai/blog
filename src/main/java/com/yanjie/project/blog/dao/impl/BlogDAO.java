package com.yanjie.project.blog.dao.impl;

import com.yanjie.project.blog.bean.po.BlogPO;
import com.yanjie.project.blog.dao.IBlogDAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Description: BlogDAO
 * Author: wangjie12
 * Create: 2015-07-14
 */
@Component
public class BlogDAO extends BaseDAO implements IBlogDAO {

    @Override
    public BlogPO queryById(Long id) {
        String sql = "select * from t_blog where id= ?";
        Object[] params = new Object[]{id};
        int[] types = new int[]{Types.INTEGER};
        List<BlogPO> blogs = jdbcTemplate.query(sql, params, types, new BlogMapper());
        if (blogs == null || blogs.isEmpty()) {
            return null;
        }
        return blogs.get(0);
    }


    @Override
    public List<BlogPO> queryAll() {
        String sql = "select * from t_blog";
        List<BlogPO> blogs = jdbcTemplate.query(sql, new BlogMapper());
        return blogs;
    }

    protected class BlogMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            BlogPO blog = new BlogPO();
            blog.setId(rs.getLong("id"));
            blog.setTitle(rs.getString("title"));
            blog.setContext(rs.getString("context"));
            return blog;
        }
    }
}
