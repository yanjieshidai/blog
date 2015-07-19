package com.yanjie.project.blog.bean.po;

import java.sql.Timestamp;

/**
 * Description: DocPO
 * Author: wangjie12
 * Create: 2015-07-19
 */
public class DocPO {
    private Long id;
    private String uuid;
    private String title;
    private String context;
    private Long creator;
    private Timestamp updateTime;
    private Timestamp createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}


/**
 * CREATE TABLE `t_doc` (
 * `id` int(18) unsigned NOT NULL AUTO_INCREMENT,
 * `uuid` varchar(32) NOT NULL,
 * `title` varchar(256) NOT NULL,
 * `context` varchar(2560) NOT NULL,
 * `creator` int(18) unsigned NOT NULL,
 * `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
 * `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='blog信息表'
 */