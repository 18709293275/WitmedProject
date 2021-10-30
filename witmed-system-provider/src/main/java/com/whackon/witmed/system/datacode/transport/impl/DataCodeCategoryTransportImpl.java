package com.whackon.witmed.system.datacode.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.datacode.pojo.vo.DataCodeCategoryVO;
import com.whackon.witmed.system.datacode.service.DataCodeCategoryService;
import com.whackon.witmed.system.datacode.transport.DataCodeCategoryTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>系统功能 - 数据编码功能 - 数据代码类别信息传输层接口实现类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 */
@RestController("dataCodeCategoryTransport")
@RequestMapping("/system/datacode/category/trans")
public class DataCodeCategoryTransportImpl implements DataCodeCategoryTransport {
	@Autowired
	private DataCodeCategoryService service;

	/**
	 * <b>根据查询对象分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<DataCodeCategoryVO> getByPage(@RequestBody QueryPageVO<DataCodeCategoryVO> queryPageVO) throws Exception {
		// 根据 QueryPageVO 分别获得 QueryVO 和 PageVO
		DataCodeCategoryVO queryVO = queryPageVO.getQueryVO();
		PageVO<DataCodeCategoryVO> pageVO = queryPageVO.getPageVO();
		return service.getByPage(queryVO, pageVO);
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public DataCodeCategoryVO getByCode(@RequestParam String code) throws Exception {
		return service.getByCode(code);
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean save(@RequestBody DataCodeCategoryVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>根据主键获得视图对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public DataCodeCategoryVO getById(@RequestBody String id) throws Exception {
		return service.getById(id);
	}
}
