package com.whackon.witmed.base.pojo.enums;

/**
 * <b>系统基础信息类 - 系统响应编码枚举信息</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ResponseCodeEnum {
	RESPONSE_CODE_SUCCESS(BaseEnumConstants.ENUM_RESPONSE_CODE_SUCCESS, "系统响应成功"),
	RESPONSE_CODE_UNAUTH(BaseEnumConstants.ENUM_RESPONSE_CODE_UNAUTH, "用户未认证"),
	RESPONSE_CODE_ERROR(BaseEnumConstants.ENUM_RESPONSE_CODE_ERROR, "系统业务处理错误"),
	RESPONSE_CODE_EXCEPTION(BaseEnumConstants.ENUM_RESPONSE_CODE_EXCEPTION, "系统响应异常");

	private Integer code;                       // 响应编码
	private String remark;                      // 响应说明

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
