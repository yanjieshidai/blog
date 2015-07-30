package com.yanjie.project.blog.base;

/**
 * Description: JdbcParm
 * Author: wangjie12
 * Create: 2015-07-30
 */
public class JdbcParam {
    private String sql;
    private Object[] params;
    private int[] types;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public int[] getTypes() {
        return types;
    }

    public void setTypes(int[] types) {
        this.types = types;
    }
}
