package com.whackon.witmed.system.dictionary.transport;


import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.dictionary.pojo.vo.DictionaryVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>系统功能 - 数据字典信息传输层接口</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
@RequestMapping("system/dictionary/trans")
public interface DictionaryTransport {
    /**
     * <b>根据查询对象分页查询</b>
     * @param queryPageVO
     * @return
     * @throws Exception
     */
    @PostMapping("/page")
    PageVO<DictionaryVO> getPageByQuery(@RequestBody QueryPageVO<DictionaryVO> queryPageVO) throws Exception;

    /**
     * <b>根据查询对象查询列表</b>
     * @param queryVO
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    List<DictionaryVO> getListByQuery(@RequestBody DictionaryVO queryVO) throws Exception;

    /**
     * <b>根据主键查询对象</b>
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/id")
    DictionaryVO getById(@RequestParam String id) throws Exception;

    /**
     * <b>根据编码查询对象</b>
     * @param code
     * @return
     * @throws Exception
     */
    @PostMapping("/code")
    DictionaryVO getByCode(@RequestParam String code) throws Exception;

    /**
     * <b>保存信息</b>
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    boolean save(@RequestBody DictionaryVO vo) throws Exception;
}
