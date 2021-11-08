package com.whackon.witmed.admin.service;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;

/**
 * <b>系统功能 - 系统用户业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AdminService {
    /**
     * <b>根据 Token 获得当前登录对象</b>
     * @param token
     * @return
     * @throws Exception
     */
    AdminVO getByToken(String token) throws Exception;
}
