package com.yanjie.project.blog.dao.impl;

import com.yanjie.project.blog.bean.po.DocPO;
import com.yanjie.project.blog.bean.po.UserAuthPO;
import com.yanjie.project.blog.dao.IUserAuthDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

/**
 * Description: UserAuthDAO
 * Author: wangjie12
 * Create: 2015-08-02
 */
@Component
public class UserAuthDAO extends BaseDAO implements IUserAuthDAO {

    private final static Logger logger = LoggerFactory.getLogger(UserAuthDAO.class);

    @Override
    public List<UserAuthPO> queryByUserId(Long userId) {
        String sql = "select * from t_user_auth where user_id= ?";
        Object[] params = new Object[]{userId};
        int[] types = new int[]{Types.INTEGER};
        List<UserAuthPO> userAuths = jdbcTemplate.query(sql, params, types, new UserAuthMapper());
        return userAuths;
    }

    @Override
    public int updateAuthInfoByUserId(Long userId, String info, short i) {
        String sql = "update t_user_auth set info=? where user_id=?";
        int[] types = new int[]{Types.VARCHAR, Types.INTEGER, Types.SMALLINT};
        Object[] params = new Object[]{info, userId, i};
        int len = jdbcTemplate.update(sql, params, types);
        return len;
    }

    @Override
    public List<UserAuthPO> queryByUserId(Long userId, short i) {
        String sql = "select * from t_user_auth where user_id= ? and auth_type=?";
        Object[] params = new Object[]{userId, i};
        int[] types = new int[]{Types.INTEGER, Types.SMALLINT};
        List<UserAuthPO> userAuths = jdbcTemplate.query(sql, params, types, new UserAuthMapper());
        return userAuths;
    }

    @Override
    public UserAuthPO insert(UserAuthPO userAuthPO) {
        String sql = "insert into t_user_auth(user_id,auth_type,auth_info,extra,update_time,create_time) values(?,?,?,?,now(),now())";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, userAuthPO.getUserId());
            ps.setShort(2, userAuthPO.getAuthType());
            ps.setString(3, userAuthPO.getAuthInfo());
            ps.setString(4, userAuthPO.getExtra());
            return ps;
        }, keyHolder);
        if (keyHolder.getKey() != null) {
            userAuthPO.setId(keyHolder.getKey().longValue());
            logger.info("插入user_auth成功。auth_user_id:" + userAuthPO.getId());
            return userAuthPO;
        } else {
            logger.info("插入user_auth失败。user_id:" + userAuthPO.getUserId() + " auth_type:" + userAuthPO.getAuthType());
            return null;
        }
    }


    protected class UserAuthMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserAuthPO userAuth = new UserAuthPO();
            userAuth.setId(rs.getLong("id"));
            userAuth.setUserId(rs.getLong("user_id"));
            userAuth.setAuthType(rs.getShort("auth_type"));
            userAuth.setAuthInfo(rs.getString("auth_info"));
            userAuth.setExtra(rs.getString("extra"));
            return userAuth;
        }
    }
}
