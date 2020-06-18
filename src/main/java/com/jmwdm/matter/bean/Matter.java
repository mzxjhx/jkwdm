package com.jmwdm.matter.bean;

import java.io.Serializable;
import java.util.Date;

import com.jmwdm.framework.BaseBean;

/**
 * @author 
 * 事项表
 */
public class Matter extends BaseBean implements Serializable {
    /**
     * 主键
     */
    private String matterKey;

    /**
     * 用户key
     */
    private String userKey;

    /**
     * 内容html
     */
    private String content;

    /**
     * 状态0-未办，1-已办
     */
    private Byte status;

    /**
     * 创建时间
     */
    private String createTime;

    private static final long serialVersionUID = 1L;

    public String getMatterKey() {
        return matterKey;
    }

    public void setMatterKey(String matterKey) {
        this.matterKey = matterKey;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}