package com.whackon.witmed.base.pojo.enums;

/**
 * <b>系统基础响应码枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ResponseCodeEnum {
    RESPONSE_SUCCESS(BaseEnumConstants.RESPONSE_SUCCESS, "系统响应业务处理成功"),
    RESPONSE_UNAUTH(BaseEnumConstants.RESPONSE_UNAUTH, "用户未认证"),
    RESPONSE_ERROR(BaseEnumConstants.RESPONSE_ERROR, "系统业务流程处理错误"),
    RESPONSE_EXCEPTION(BaseEnumConstants.RESPONSE_EXCEPTION, "系统响应异常");

    private Integer code;                        // 编码
    private String remark;                      // 说明

    private ResponseCodeEnum(Integer code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
