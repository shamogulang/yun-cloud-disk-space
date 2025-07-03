package com.example.cloudspace.entity;

import java.util.Date;

public class Space {
    private Long id;
    private Long userId;
    private Long totalSpace;
    private Long usedSpace;
    private Date createTime;
    private Date updateTime;

    // getter和setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getTotalSpace() { return totalSpace; }
    public void setTotalSpace(Long totalSpace) { this.totalSpace = totalSpace; }
    public Long getUsedSpace() { return usedSpace; }
    public void setUsedSpace(Long usedSpace) { this.usedSpace = usedSpace; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
} 