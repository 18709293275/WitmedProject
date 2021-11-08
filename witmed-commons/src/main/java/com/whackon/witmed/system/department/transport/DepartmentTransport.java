package com.whackon.witmed.system.department.transport;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.department.pojo.vo.DepartmentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>系统功能 - 系统人员部门信息传输层接口</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
@RequestMapping("system/department/trans")
public interface DepartmentTransport {
    /**
     * <b>根据查询对象分页查询</b>
     * @param queryPageVO
     * @return
     * @throws Exception
     */
    @PostMapping("/page")
    PageVO<DepartmentVO> getPageByQuery(@RequestBody QueryPageVO<DepartmentVO> queryPageVO) throws Exception;

    /**
     * <b>根据查询对象查询列表</b>
     * @param queryVO
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    List<DepartmentVO> getListByQuery(@RequestBody DepartmentVO queryVO) throws Exception;

    /**
     * <b>根据主键查询对象</b>
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/id")
    DepartmentVO getById(@RequestParam String id) throws Exception;

    /**
     * <b>根据编码查询对象</b>
     * @param code
     * @return
     * @throws Exception
     */
    @PostMapping("/code")
    DepartmentVO getByCode(@RequestParam String code) throws Exception;

    /**
     * <b>保存信息</b>
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    boolean save(@RequestBody DepartmentVO vo) throws Exception;
}
