package com.whackon.witmed.division.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whackon.witmed.division.dao.DivisionDao;
import com.whackon.witmed.division.service.DivisionService;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.util.IdGenerator;
import com.whackon.witmed.system.division.pojo.entity.Division;
import com.whackon.witmed.system.division.pojo.vo.DivisionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>系统功能 - 行政区划信息业务层接口实现类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("divisionService")
@Transactional
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionDao dao;
    @Autowired
    private IdGenerator idGenerator;

    /**
     * <b>根据查询对象分页查询</b>
     * @param queryVO
     * @param pageVO
     * @return
     * @throws Exception
     */
    @Override
    public PageVO<DivisionVO> getPageByQuery(DivisionVO queryVO, PageVO<DivisionVO> pageVO) throws Exception {
        // 将查询视图切换为查询实体
        Division query = Division.getEntity(queryVO);
        // 开启 PageHelper 分页查询过滤器
        PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
        // 进行列表查询
        List<Division> list = dao.findListByQuery(query);
        // 根据列表获得 PageInfo 对象
        PageInfo<Division> pageInfo = new PageInfo<Division>(list);
        // 提取数据
        List<DivisionVO> voList = new ArrayList<DivisionVO>();
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
            for (Division entity : pageInfo.getList()) {
                voList.add(DivisionVO.getVO(entity));
            }
        }
        pageVO.setList(voList);
        pageVO.setTotalSize(pageInfo.getTotal());
        pageVO.setTotalPages(pageInfo.getPages());
        return pageVO;
    }

    /**
     * <b>根据查询对象查询列表</b>
     * @param queryVO
     * @return
     * @throws Exception
     */
    @Override
    public List<DivisionVO> getListByQuery(DivisionVO queryVO) throws Exception {
        // 将查询视图切换为查询实体
        Division query = Division.getEntity(queryVO);
        // 进行列表查询
        List<Division> entityList = dao.findListByQuery(query);
        // 将实体列表切换为视图列表
        List<DivisionVO> voList = new ArrayList<DivisionVO>();
        if (voList != null && !voList.isEmpty()) {
            for (Division entity : entityList) {
                voList.add(DivisionVO.getVO(entity));
            }
        }
        return voList;
    }

    /**
     * <b>根据主键查询对象</b>
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public DivisionVO getById(String id) throws Exception {
        // 创建查询实体
        Division query = new Division();
        query.setId(id);
        // 进行列表查询
        List<Division> entityList = dao.findListByQuery(query);
        if (entityList != null && !entityList.isEmpty()) {
            return DivisionVO.getVO(entityList.get(0));
        }
        return null;
    }

    /**
     * <b>根据编码查询对象</b>
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public DivisionVO getByCode(String code) throws Exception {
        // 创建查询实体
        Division query = new Division();
        query.setCode(code);
        // 进行列表查询
        List<Division> entityList = dao.findListByQuery(query);
        if (entityList != null && !entityList.isEmpty()) {
            return DivisionVO.getVO(entityList.get(0));
        }
        return null;
    }

    /**
     * <b>保存信息</b>
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public boolean save(DivisionVO vo) throws Exception {
        // 将视图信息切换为实体信息
        Division entity = Division.getEntity(vo);
        // 判断此时的数据是否有 ID
        if (StrUtil.isBlank(vo.getId())) {
            // 未包含主键，则进行新增操作
            // 设置主键
            entity.setId(idGenerator.createId());
            if (dao.save(entity) > 0) {
                return true;
            }
        } else {
            // 包含主键，进行修改操作
            if (dao.update(entity) > 0) {
                return true;
            }
        }
        return false;
    }
}
