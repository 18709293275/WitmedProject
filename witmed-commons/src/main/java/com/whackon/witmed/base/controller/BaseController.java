package com.whackon.witmed.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>系统基础控制层类</b>
 * <p>
 *     系统基础控制层类依赖注入了以下属性：<br/>
 *     1、HttpServletRequest<br/>
 *     2、HttpServletResponse<br/>
 *     3、HttpSession<br/>
 *     本项目所有功能控制层类<b>都必须继承于本系统基础控制层类</b>。
 * </p>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("baseController")
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;
}
