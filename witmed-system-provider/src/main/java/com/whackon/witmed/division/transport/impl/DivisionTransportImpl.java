package com.whackon.witmed.division.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.division.service.DivisionService;
import com.whackon.witmed.system.division.pojo.vo.DivisionVO;
import com.whackon.witmed.system.division.transport.DivisionTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>系统功能 - 行政区划信息传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("divisionTransport")
@RequestMapping("system/division/trans")
public class DivisionTransportImpl implements DivisionTransport {
    @Autowired
    private DivisionService service;

    /**
     * <b>根据查询对象分页查询</b>
     * @param queryPageVO
     * @return
     * @throws Exception
     */
    @PostMapping("/page")
    @Override
    public PageVO<DivisionVO> getPageByQuery(@RequestBody QueryPageVO<DivisionVO> queryPageVO) throws Exception {
        DivisionVO queryVO = queryPageVO.getQueryVO();
        PageVO<DivisionVO> pageVO = queryPageVO.getPageVO();
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
    public List<DivisionVO> getListByQuery(@RequestBody DivisionVO queryVO) throws Exception {
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
    public DivisionVO getById(@RequestParam String id) throws Exception {
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
    public DivisionVO getByCode(@RequestParam String code) throws Exception {
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
    public boolean save(@RequestBody DivisionVO vo) throws Exception {
        return service.save(vo);
    }
}
