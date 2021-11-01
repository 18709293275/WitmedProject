package com.whackon.witmed.system.info.transport;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.info.pojo.vo.IdentityVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息传输层接口</b>
 * @author He'l'lo'World
 * @version 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
@RequestMapping("/system/info/identity/trans")
public interface IdentityTransport {
	/**
	 * <b>根据查询对象分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<IdentityVO> getPage(@RequestBody QueryPageVO<IdentityVO> queryPageVO) throws Exception;
}
