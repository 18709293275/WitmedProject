package com.whackon.witmed.dictionary.dao;

import com.whackon.witmed.system.dictionary.pojo.entity.Dictionary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>系统功能 - 数据字典信息数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface DictionaryDao {
    /**
     * <b>根据查询对象查询列表</b>
     * @param query
     * @return
     * @throws Exception
     */
    List<Dictionary> findListByQuery(Dictionary query) throws Exception;

    /**
     * <b>保存信息</b>
     * @param entity
     * @return
     * @throws Exception
     */
    int save(Dictionary entity) throws Exception;

    /**
     * <b>修改信息</b>
     * @param entity
     * @return
     * @throws Exception
     */
    int update(Dictionary entity) throws Exception;
}
