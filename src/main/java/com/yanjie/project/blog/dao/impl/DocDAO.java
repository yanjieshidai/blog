package com.yanjie.project.blog.dao.impl;

import com.yanjie.project.blog.bean.po.DocPO;
import com.yanjie.project.blog.dao.IDocDAO;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Description: BlogDAO
 * Author: wangjie12
 * Create: 2015-07-14
 */
@Component
public class DocDAO extends BaseDAO implements IDocDAO {

    @Override
    public DocPO create(DocPO docPO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into t_doc(uuid,title,context,creator,update_time,create_time) values(?,?,?,?,now(),now())";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, docPO.getUuid());
            ps.setString(2, docPO.getTitle());
            ps.setString(3, docPO.getContext());
            ps.setLong(4, docPO.getCreator());
            return ps;
        }, keyHolder);
        if (keyHolder.getKey() != null) {
            docPO.setId(keyHolder.getKey().longValue());
            System.out.println("插入成功！");
            return docPO;
        } else {
            System.out.println("插入失败！");
            return null;
        }
    }
}
