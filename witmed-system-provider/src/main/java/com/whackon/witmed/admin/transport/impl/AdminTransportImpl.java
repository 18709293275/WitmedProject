package com.whackon.witmed.admin.transport.impl;

import com.whackon.witmed.admin.service.AdminService;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>系统功能 - 系统用户传输层接口实现类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("adminTransport")
@RequestMapping("/system/admin/trans")
public class AdminTransportImpl implements AdminTransport {
    @Autowired
    private AdminService service;

    /**
     * <b>根据 Token 获得当前登录对象</b>
     * @param token
     * @return
     * @throws Exception
     */
    @PostMapping("/token")
    @Override
    public AdminVO getByToken(@RequestBody String token) throws Exception {
        return service.getByToken(token);
    }
}
