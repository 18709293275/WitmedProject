package com.whackon.witmed.division.dao;

import com.whackon.witmed.system.division.pojo.entity.Division;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>系统功能 - 行政区划信息数据持久层接口</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface DivisionDao {
    /**
     * <b>根据查询对象查询列表</b>
     * @param query
     * @return
     * @throws Exception
     */
    List<Division> findListByQuery(Division query) throws Exception;

    /**
     * <b>保存信息</b>
     * @param entity
     * @return
     * @throws Exception
     */
    int save(Division entity) throws Exception;

    /**
     * <b>修改信息</b>
     * @param entity
     * @return
     * @throws Exception
     */
    int update(Division entity) throws Exception;
}
