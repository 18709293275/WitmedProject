package com.whackon.witmed.dictionary.controller;

import cn.hutool.core.util.StrUtil;
import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.base.util.BaseConstants;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import com.whackon.witmed.system.dictionary.pojo.vo.DictionaryVO;
import com.whackon.witmed.system.dictionary.transport.DictionaryTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>系统功能 - 数据字典信息控制层类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "系统功能 - 数据字典信息控制层类", tags = "系统功能 - 数据字典信息控制层类")
@RestController("dictionaryController")
@RequestMapping("/system/dictionary")
public class DictionaryController extends BaseController {
    @Autowired
    private DictionaryTransport transport;
    @Autowired
    private AdminTransport adminTransport;

    /**
     * <b>根据查询视图分页查询</b>
     * @param pageNum
     * @param pageSize
     * @param queryVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "根据查询视图分页查询", httpMethod = "POST", protocols = "application/json")
    @PostMapping("/page/{pageNum}/{pageSize}")
    public ResponseVO queryPageByQuery(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @RequestBody DictionaryVO queryVO)
            throws Exception {
        // 判断用户是否已经登录
        AdminVO adminVO = adminTransport.getByToken(request.getHeader(BaseConstants.TOKE_HEADER));
        if (adminVO != null) {
            // 创建查询分页对象
            QueryPageVO<DictionaryVO> queryPageVO = new QueryPageVO<DictionaryVO>(queryVO, pageNum, pageSize);
            // 进行分页查询
            PageVO<DictionaryVO> pageVO = transport.getPageByQuery(queryPageVO);
            return ResponseVO.getSuccessResponseVO(pageVO);
        }
        return ResponseVO.getUnauthResponseVO();
    }

    /**
     * <b>根据查询对象查询列表</b>
     * @param queryVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "根据查询对象查询列表", httpMethod = "POST", protocols = "application/json")
    @PostMapping("/list")
    public ResponseVO queryListByQuery(@RequestBody DictionaryVO queryVO) throws Exception {
        // 判断用户是否已经登录
        AdminVO adminVO = adminTransport.getByToken(request.getHeader(BaseConstants.TOKE_HEADER));
        if (adminVO != null) {
            return ResponseVO.getSuccessResponseVO(transport.getListByQuery(queryVO));
        }
        return ResponseVO.getUnauthResponseVO();

    }

    /**
     * <b>根据查询主键查询对象</b>
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "根据查询主键查询对象", httpMethod = "GET", protocols = "application/json")
    @GetMapping("/id/{id}")
    public ResponseVO queryById(@PathVariable("id") String id) throws Exception {
        // 判断用户是否已经登录
        AdminVO adminVO = adminTransport.getByToken(request.getHeader(BaseConstants.TOKE_HEADER));
        if (adminVO != null) {
            return ResponseVO.getSuccessResponseVO(transport.getById(id));
        }
        return ResponseVO.getUnauthResponseVO();
    }

    /**
     * <b>根据查询编码查询对象</b>
     * @param code
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "根据查询编码查询对象", httpMethod = "GET", protocols = "application/json")
    @GetMapping("/code/{code}")
    public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception {
        // 判断用户是否已经登录
        AdminVO adminVO = adminTransport.getByToken(request.getHeader(BaseConstants.TOKE_HEADER));
        if (adminVO != null) {
            return ResponseVO.getSuccessResponseVO(transport.getByCode(code));
        }
        return ResponseVO.getUnauthResponseVO();
    }

    /**
     * <b>插入信息</b>
     * @param vo
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "插入信息", httpMethod = "POST", protocols = "application/json")
    @PostMapping("/insert")
    public ResponseVO insert(@RequestBody DictionaryVO vo) throws Exception {
        // 判断用户是否登录
        AdminVO adminVO = adminTransport.getByToken(request.getHeader(BaseConstants.TOKE_HEADER));
        if (adminVO != null) {
            // 校验用户所填写信息是否有效
            if (StrUtil.isBlank(vo.getName()) && StrUtil.isBlank(vo.getCode())) {
                // 进行唯编码一性校验
                if (transport.getByCode(vo.getCode()) == null) {
                    // 设置添加对象
                    vo.setCreateUser(adminVO.getId());
                    if (transport.save(vo)) {
                        return ResponseVO.getSuccessResponseVO();
                    }
                    return ResponseVO.getErrorResponseVO("保存失败");
                }
                return ResponseVO.getErrorResponseVO("该编码已被占用");
            }
            return ResponseVO.getErrorResponseVO("未填写有效信息");
        }
        return ResponseVO.getUnauthResponseVO();
    }

    /**
     * <b>修改信息</b>
     * @param vo
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "修改信息", httpMethod = "POST", protocols = "application/json")
    @PostMapping("/update")
    public ResponseVO update(@RequestBody DictionaryVO vo) throws Exception {
        // 判断用户是否登录
        AdminVO adminVO = adminTransport.getByToken(request.getHeader(BaseConstants.TOKE_HEADER));
        if (adminVO != null) {
            // 校验用户所填写信息是否有效
            if (StrUtil.isBlank(vo.getName()) && StrUtil.isBlank(vo.getCode())) {
                // 进行唯编码一性校验
                DictionaryVO checkVO = transport.getByCode(vo.getCode());
                if (checkVO == null || (checkVO != null && vo.getId().equals(checkVO.getId()))) {
                    // 设置添加对象
                    vo.setCreateUser(adminVO.getId());
                    if (transport.save(vo)) {
                        return ResponseVO.getSuccessResponseVO();
                    }
                    return ResponseVO.getErrorResponseVO("保存失败");
                }
                return ResponseVO.getErrorResponseVO("该编码已被占用");
            }
            return ResponseVO.getErrorResponseVO("未填写有效信息");
        }
        return ResponseVO.getUnauthResponseVO();
    }
}
