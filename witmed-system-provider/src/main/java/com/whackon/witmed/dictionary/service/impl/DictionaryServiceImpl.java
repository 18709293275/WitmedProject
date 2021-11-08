package com.whackon.witmed.dictionary.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.util.IdGenerator;
import com.whackon.witmed.dictionary.dao.DictionaryDao;
import com.whackon.witmed.dictionary.service.DictionaryService;
import com.whackon.witmed.system.dictionary.pojo.entity.Dictionary;
import com.whackon.witmed.system.dictionary.pojo.vo.DictionaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>系统功能 - 数据字典信息业务层接口实现类</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryDao dao;
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
    public PageVO<DictionaryVO> getPageByQuery(DictionaryVO queryVO, PageVO<DictionaryVO> pageVO) throws Exception {
        // 将查询视图切换为查询实体
        Dictionary query = Dictionary.getEntity(queryVO);
        // 开启 PageHelper 分页查询过滤器
        PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
        // 进行列表查询
        List<Dictionary> list = dao.findListByQuery(query);
        // 根据列表获得 PageInfo 对象
        PageInfo<Dictionary> pageInfo = new PageInfo<Dictionary>(list);
        // 提取数据
        List<DictionaryVO> voList = new ArrayList<DictionaryVO>();
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
            for (Dictionary entity : pageInfo.getList()) {
                voList.add(DictionaryVO.getVO(entity));
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
    public List<DictionaryVO> getListByQuery(DictionaryVO queryVO) throws Exception {
        // 将查询视图切换为查询实体
        Dictionary query = Dictionary.getEntity(queryVO);
        // 进行列表查询
        List<Dictionary> entityList = dao.findListByQuery(query);
        // 将实体列表切换为视图列表
        List<DictionaryVO> voList = new ArrayList<DictionaryVO>();
        if (voList != null && !voList.isEmpty()) {
            for (Dictionary entity : entityList) {
                voList.add(DictionaryVO.getVO(entity));
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
    public DictionaryVO getById(String id) throws Exception {
        // 创建查询实体
        Dictionary query = new Dictionary();
        query.setId(id);
        // 进行列表查询
        List<Dictionary> entityList = dao.findListByQuery(query);
        if (entityList != null && !entityList.isEmpty()) {
            return DictionaryVO.getVO(entityList.get(0));
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
    public DictionaryVO getByCode(String code) throws Exception {
        // 创建查询实体
        Dictionary query = new Dictionary();
        query.setCode(code);
        // 进行列表查询
        List<Dictionary> entityList = dao.findListByQuery(query);
        if (entityList != null && !entityList.isEmpty()) {
            return DictionaryVO.getVO(entityList.get(0));
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
    public boolean save(DictionaryVO vo) throws Exception {
        // 将视图信息切换为实体信息
        Dictionary entity = Dictionary.getEntity(vo);
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
