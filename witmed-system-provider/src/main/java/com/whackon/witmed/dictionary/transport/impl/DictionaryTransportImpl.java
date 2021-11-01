package com.whackon.witmed.dictionary.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.dictionary.service.DictionaryService;
import com.whackon.witmed.system.dictionary.pojo.vo.DictionaryVO;
import com.whackon.witmed.system.dictionary.transport.DictionaryTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>系统功能 - 数据字典信息传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("dictionaryTransport")
@RequestMapping("system/dictionary/trans")
public class DictionaryTransportImpl implements DictionaryTransport {
    @Autowired
    private DictionaryService service;

    /**
     * <b>根据查询对象分页查询</b>
     * @param queryPageVO
     * @return
     * @throws Exception
     */
    @PostMapping("/page")
    @Override
    public PageVO<DictionaryVO> getPageByQuery(@RequestBody QueryPageVO<DictionaryVO> queryPageVO) throws Exception {
        DictionaryVO queryVO = queryPageVO.getQueryVO();
        PageVO<DictionaryVO> pageVO = queryPageVO.getPageVO();
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
    public List<DictionaryVO> getListByQuery(@RequestBody DictionaryVO queryVO) throws Exception {
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
    public DictionaryVO getById(@RequestParam String id) throws Exception {
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
    public DictionaryVO getByCode(@RequestParam String code) throws Exception {
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
    public boolean save(@RequestBody DictionaryVO vo) throws Exception {
        return service.save(vo);
    }
}
