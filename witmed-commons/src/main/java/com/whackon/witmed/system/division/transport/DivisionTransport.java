package com.whackon.witmed.system.division.transport;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.division.pojo.vo.DivisionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>系统功能 - 行政区划信息传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
@RequestMapping("system/division/trans")
public interface DivisionTransport {
    /**
     * <b>根据查询对象分页查询</b>
     * @param queryPageVO
     * @return
     * @throws Exception
     */
    @PostMapping("/page")
    PageVO<DivisionVO> getPageByQuery(@RequestBody QueryPageVO<DivisionVO> queryPageVO) throws Exception;

    /**
     * <b>根据查询对象查询列表</b>
     * @param queryVO
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    List<DivisionVO> getListByQuery(@RequestBody DivisionVO queryVO) throws Exception;

    /**
     * <b>根据主键查询对象</b>
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/id")
    DivisionVO getById(@RequestParam String id) throws Exception;

    /**
     * <b>根据编码查询对象</b>
     * @param code
     * @return
     * @throws Exception
     */
    @PostMapping("/code")
    DivisionVO getByCode(@RequestParam String code) throws Exception;

    /**
     * <b>保存信息</b>
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    boolean save(@RequestBody DivisionVO vo) throws Exception;
}
