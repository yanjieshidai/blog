package com.yanjie.project.blog.dao.impl;

import com.yanjie.project.blog.bean.po.BlogPO;
import com.yanjie.project.blog.dao.IBlogDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

/**
 * Description: BlogDAO
 * Author: wangjie12
 * Create: 2015-07-14
 */
@Component
public class BlogDAO extends BaseDAO implements IBlogDAO {
    private final static Logger logger = LoggerFactory.getLogger(BlogDAO.class);

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

    @Override
    public BlogPO queryByDocId(Long id) {
        String sql = "select * from t_blog where doc_id= ?";
        Object[] params = new Object[]{id};
        int[] types = new int[]{Types.INTEGER};
        List<BlogPO> blogs = jdbcTemplate.query(sql, params, types, new BlogMapper());
        if (blogs == null || blogs.isEmpty()) {
            return null;
        }
        return blogs.get(0);
    }

    @Override
    public BlogPO insert(BlogPO blogPO) {
        String sql = "insert into t_blog(title,context,doc_id,update_time,create_time) values(?,?,?,now(),now())";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, blogPO.getTitle());
            ps.setString(2, blogPO.getContext());
            ps.setLong(3, blogPO.getDocId());
            return ps;
        }, keyHolder);
        if (keyHolder.getKey() != null) {
            blogPO.setId(keyHolder.getKey().longValue());
            logger.info("插入blog成功。blog_id:" + blogPO.getId());
            return blogPO;
        } else {
            logger.info("插入blog失败。doc_id:" + blogPO.getDocId());
            return null;
        }
    }

    @Override
    public boolean updateBlogById(BlogPO blogPO) {
        String sql = "update t_blog set title=?,context=?,doc_id=? where id=?";
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER};
        Object[] params = new Object[]{blogPO.getTitle(), blogPO.getContext(), blogPO.getDocId(), blogPO.getId()};
        int len = jdbcTemplate.update(sql, params, types);
        if (len == 1) {
            return true;
        }
        return false;
    }

    protected class BlogMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            BlogPO blog = new BlogPO();
            blog.setId(rs.getLong("id"));
            blog.setTitle(rs.getString("title"));
            blog.setContext(rs.getString("context"));
            blog.setDocId(rs.getLong("doc_id"));
            return blog;
        }
    }
}
