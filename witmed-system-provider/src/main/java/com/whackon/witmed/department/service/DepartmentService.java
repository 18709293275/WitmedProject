package com.whackon.witmed.department.service;


import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.system.department.pojo.vo.DepartmentVO;

import java.util.List;

/**
 * <b>系统功能 - 系统人员部门信息业务层接口</b>
 * @author He'l'lo'World 
 * @version 1.0.0
 * @since 1.0.0
 */
public interface DepartmentService {
    /**
     * <b>根据查询对象分页查询</b>
     * @param queryVO
     * @param pageVO
     * @return
     * @throws Exception
     */
    PageVO<DepartmentVO> getPageByQuery(DepartmentVO queryVO, PageVO<DepartmentVO> pageVO) throws Exception;

    /**
     * <b>根据查询对象查询列表</b>
     * @param queryVO
     * @return
     * @throws Exception
     */
    List<DepartmentVO> getListByQuery(DepartmentVO queryVO) throws Exception;

    /**
     * <b>根据主键查询对象</b>
     * @param id
     * @return
     * @throws Exception
     */
    DepartmentVO getById(String id) throws Exception;

    /**
     * <b>根据编码查询对象</b>
     * @param code
     * @return
     * @throws Exception
     */
    DepartmentVO getByCode(String code) throws Exception;

    /**
     * <b>保存信息</b>
     * @param vo
     * @return
     * @throws Exception
     */
    boolean save(DepartmentVO vo) throws Exception;
}
