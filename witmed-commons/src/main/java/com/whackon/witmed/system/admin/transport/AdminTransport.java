package com.whackon.witmed.system.admin.transport;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>系统功能 - 系统用户传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
@RequestMapping("/system/admin/trans")
public interface AdminTransport {
    /**
     * <b>根据 Token 获得当前登录对象</b>
     * @param token
     * @return
     * @throws Exception
     */
    @PostMapping("/token")
    AdminVO getByToken(@RequestBody String token) throws Exception;
}
