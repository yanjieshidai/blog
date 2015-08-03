package com.yanjie.project.blog.dao.impl;

import com.yanjie.project.blog.bean.po.DocPO;
import com.yanjie.project.blog.bean.po.UserPO;
import com.yanjie.project.blog.dao.IUserDAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Description: UserDAO
 * Author: wangjie12
 * Create: 2015-08-02
 */
@Component
public class UserDAO extends BaseDAO implements IUserDAO {
    @Override
    public UserPO queryByLogin(String login, String passwd) {
        String sql = "select * from t_user where login= ? and passwd=?";
        Object[] params = new Object[]{login, passwd};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR};
        List<UserPO> users = jdbcTemplate.query(sql, params, types, new UserMapper());
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public UserPO queryById(Long id) {
        String sql = "select * from t_user where id= ?";
        Object[] params = new Object[]{id};
        int[] types = new int[]{Types.INTEGER};
        List<UserPO> users = jdbcTemplate.query(sql, params, types, new UserMapper());
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    protected class UserMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserPO userPO = new UserPO();
            userPO.setId(rs.getLong("id"));
            userPO.setLogin(rs.getString("login"));
            userPO.setName(rs.getString("name"));
            userPO.setPasswd(rs.getString("passwd"));
            userPO.setPhone(rs.getString("phone"));
            userPO.setEmail(rs.getString("email"));
            return userPO;
        }
    }
}
