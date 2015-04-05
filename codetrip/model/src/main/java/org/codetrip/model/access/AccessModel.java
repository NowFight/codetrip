package org.codetrip.model.access;

import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/1/29.
 */
public class AccessModel extends BaseModel {
    /*
    * 序号
    * */
    private Long id;

    /*
    * 用户ID
    * */
    private Long userId;

    /*
    * 用户的IP
    * 格式为：XXX.XXX.XXX.XXX
    * */
    private String ipAddr;

    /*
    * 用户访问日期
    * 格式为：YYYY-MM-DD-HH-MM-SS
    * */
    private String accessTime;

    //setter & getter


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

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }
}
