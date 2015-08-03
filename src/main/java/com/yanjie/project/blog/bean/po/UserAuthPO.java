package com.yanjie.project.blog.bean.po;

/**
 * Description: UserAuthPO
 * Author: wangjie12
 * Create: 2015-08-02
 */
public class UserAuthPO {
    private Long id;
    private Long userId;
    private Short authType;
    private String authInfo;
    private String extra;

    public UserAuthPO(){}

    public UserAuthPO(Long userId, Short authType, String authInfo) {
        this.userId = userId;
        this.authType = authType;
        this.authInfo = authInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Short getAuthType() {
        return authType;
    }

    public void setAuthType(Short authType) {
        this.authType = authType;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
