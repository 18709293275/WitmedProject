package com.whackon.witmed.admin.service.impl;

import com.whackon.witmed.admin.service.AdminService;
import com.whackon.witmed.base.util.RedisUtil;
import com.whackon.witmed.base.util.TokenUtil;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>系统功能 - 系统用户业务层接口实现类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private RedisUtil redisUtil;

    /**
     * <b>根据 Token 获得当前登录对象</b>
     * @param token
     * @return
     * @throws Exception
     */
    @Override
    public AdminVO getByToken(String token) throws Exception {
        // 根据用户所给定的 Token 进行校验
        if (TokenUtil.verifyToken(token) != null) {
            // token 校验有效，则使用 token 为 key 从 Redis 中获取当前登录对象
            AdminVO adminVO = (AdminVO) redisUtil.getFromRedis(token, AdminVO.class);
            return adminVO;
        }
        return null;
    }
}
