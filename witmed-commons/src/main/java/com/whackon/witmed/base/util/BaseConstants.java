package com.whackon.witmed.base.util;

import java.util.Properties;

/**
 * <b>系统级别基础常量类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseConstants {
    private static final Properties props = new Properties();

    static {
        try {
            // 使用静态代码块加载位于 src/props/base 下的配置文件 base.properties
            BaseConstants.class.getClassLoader().getResourceAsStream("props/base/base.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Swagger 配置信息：文档标题</b>
     */
    public static final String SWAGGER_TITLE = props.getProperty("base.swagger.title");

    /**
     * <b>Swagger 配置信息：文档描述</b>
     */
    public static final String SWAGGER_DESCRIPTION = props.getProperty("base.swagger.description");

    /**
     * <b>Swagger 配置信息：文档版本</b>
     */
    public static final String SWAGGER_VERSION = props.getProperty("base.swagger.version");

    /**
     * <b>Swagger 配置信息：文档联系人姓名</b>
     */
    public static final String SWAGGER_CONTACT_NAME = props.getProperty("base.swagger.contact.name");

    /**
     * <b>Swagger 配置信息：文档联系人网址</b>
     */
    public static final String SWAGGER_CONTACT_URL = props.getProperty("base.swagger.contact.url");

    /**
     * <b>Swagger 配置信息：文档联系人电子邮件地址</b>
     */
    public static final String SWAGGER_CONTACT_EMAIL = props.getProperty("base.swagger.contact.email");

    /**
     * <b>Swagger 配置信息：文档扫描基础包位置</b>
     */
    public static final String SWAGGER_SCAN_PACKAGE = props.getProperty("base.swagger.scan.package");

    /**
     * <b>分页信息：当前页码</b>
     */
    public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("base.page.num"));

    /**
     * <b>分页信息：每页显示数量</b>
     */
    public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("base.page.size"));

    /**
     * <b>系统秘钥信息</b>
     */
    public static final String SECRET_KEY = props.getProperty("base.secret.key");

    /**
     * <b>Token 存储 HTTP 消息头位置</b>
     */
    public static final String TOKE_HEADER = props.getProperty("base.token.header");
}
