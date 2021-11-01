package com.whackon.witmed.base.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>系统基础视图信息</b>
 * <p>
 *     系统基础视图信息设置了如下属性：<br/>
 *     1、status：系统状态<br/>
 *     2、createUser：创建人<br/>
 *     3、createTime：创建时间<br/>
 *     4、updateUser：修改人<br/>
 *     5、updateTime：修改时间<br/>
 *     本项目所有视图信息<b>都必须继承于本统基础视图信息</b>。
 * </p>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统基础视图信息")
public class BaseVO implements Serializable {
    private static final long serialVersionUID = 5307507834353921384L;
    @ApiModelProperty(value = "系统状态")
    private String status;                      // 系统状态
    @ApiModelProperty(value = "创建人")
    private String createUser;                  // 创建人
    @ApiModelProperty(value = "创建时间")
    private Date createTime;                    // 创建时间
    @ApiModelProperty(value = "修改人")
    private String updateUser;                  // 修改人
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;                    // 修改时间

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
