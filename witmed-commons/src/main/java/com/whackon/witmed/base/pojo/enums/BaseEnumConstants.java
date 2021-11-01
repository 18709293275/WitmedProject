package com.whackon.witmed.base.pojo.enums;

import java.util.Properties;

/**
 * <b>系统级别基础枚举信息常量类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
class BaseEnumConstants {
    private static final Properties props = new Properties();

    static {
        try {
            // 使用静态代码块加载位于 src/props/base 下的配置文件 base.properties
            BaseEnumConstants.class.getClassLoader().getResourceAsStream("props/base/enums.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>系统状态枚举信息：启用状态</b>
     */
    static final String STATUS_ENABLE = props.getProperty("enum.status.enable");

    /**
     * <b>系统状态枚举信息：禁用状态</b>
     */
    static final String STATUS_DISABLE = props.getProperty("enum.status.disable");

    /**
     * <b>系统响应码枚举信息：系统响应业务处理成功</b>
     */
    static final Integer RESPONSE_SUCCESS = Integer.parseInt(props.getProperty("enum.response.success"));

    /**
     * <b>系统响应码枚举信息：用户未认证</b>
     */
    static final Integer RESPONSE_UNAUTH = Integer.parseInt(props.getProperty("enum.response.unauth"));

    /**
     * <b>系统响应码枚举信息：系统业务流程处理错误</b>
     */
    static final Integer RESPONSE_ERROR = Integer.parseInt(props.getProperty("enum.response.error"));

    /**
     * <b>系统响应码枚举信息：系统响应异常</b>
     */
    static final Integer RESPONSE_EXCEPTION = Integer.parseInt(props.getProperty("enum.response.exception"));
}
