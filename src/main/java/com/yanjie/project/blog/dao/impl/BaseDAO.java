package com.yanjie.project.blog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Description: BaseDAO
 * Author: wangjie12
 * Create: 2015-07-14
 */
public class BaseDAO {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
