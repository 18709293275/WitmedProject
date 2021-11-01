package com.whackon.witmed.system.info.controller;

import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.system.info.pojo.vo.IdentityVO;
import com.whackon.witmed.system.info.transport.IdentityTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息控制层</b>
 * @author He'l'lo'World
 * @version 1.0.0
 */
@Api(value = "智慧医疗信息平台 - 系统用户身份信息交互接口", tags = "智慧医疗信息平台 - 系统用户身份信息交互接口")
@RestController("identityController")
@RequestMapping("/system/info/identity")
public class IdentityController extends BaseController {
	@Autowired
	private IdentityTransport transport;

	/**
	 * <b>根据查询对象分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询对象分页查询", notes = "根据查询对象分页查询")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO<PageVO<IdentityVO>> queryPage(
			@PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize,
			@RequestBody IdentityVO queryVO) throws Exception {
		// 根据查询视图和分页视图创建 QueryPageVO 对象
		QueryPageVO<IdentityVO> queryPageVO = new QueryPageVO<IdentityVO>(queryVO, pageNum, pageSize);
		// 调用传输层，根据查询视图，和分页信息进行分页查询
		PageVO<IdentityVO> pageVO = transport.getPage(queryPageVO);
		// 得到分页对象，创建对应响应对象
		return ResponseVO.getSuccessResponseVO(pageVO);
	}
}
