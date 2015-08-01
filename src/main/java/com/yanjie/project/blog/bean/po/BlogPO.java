package com.yanjie.project.blog.bean.po;

import java.io.Serializable;

/**
 * Description: BlogPO
 * Author: wangjie12
 * Create: 2015-07-14
 */
public class BlogPO {
    private Long id;
    private String title;
    private String context;
    private long docId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getDocId() {
        return docId;
    }
}
