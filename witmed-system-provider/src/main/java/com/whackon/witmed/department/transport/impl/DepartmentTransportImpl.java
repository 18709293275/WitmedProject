package com.whackon.witmed.department.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.department.service.DepartmentService;
import com.whackon.witmed.system.department.pojo.vo.DepartmentVO;
import com.whackon.witmed.system.department.transport.DepartmentTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>系统功能 - 系统人员部门信息传输层接口实现类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("departmentTransport")
@RequestMapping("system/department/trans")
public class DepartmentTransportImpl implements DepartmentTransport {
    @Autowired
    private DepartmentService service;

    /**
     * <b>根据查询对象分页查询</b>
     * @param queryPageVO
     * @return
     * @throws Exception
     */
    @PostMapping("/page")
    @Override
    public PageVO<DepartmentVO> getPageByQuery(@RequestBody QueryPageVO<DepartmentVO> queryPageVO) throws Exception {
        DepartmentVO queryVO = queryPageVO.getQueryVO();
        PageVO<DepartmentVO> pageVO = queryPageVO.getPageVO();
        return service.getPageByQuery(queryVO, pageVO);
    }

    /**
     * <b>根据查询对象查询列表</b>
     * @param queryVO
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @Override
    public List<DepartmentVO> getListByQuery(@RequestBody DepartmentVO queryVO) throws Exception {
        return service.getListByQuery(queryVO);
    }

    /**
     * <b>根据主键查询对象</b>
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/id")
    @Override
    public DepartmentVO getById(@RequestParam String id) throws Exception {
        return service.getById(id);
    }

    /**
     * <b>根据编码查询对象</b>
     * @param code
     * @return
     * @throws Exception
     */
    @PostMapping("/code")
    @Override
    public DepartmentVO getByCode(@RequestParam String code) throws Exception {
        return service.getByCode(code);
    }

    /**
     * <b>保存信息</b>
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    @Override
    public boolean save(@RequestBody DepartmentVO vo) throws Exception {
        return service.save(vo);
    }
}
