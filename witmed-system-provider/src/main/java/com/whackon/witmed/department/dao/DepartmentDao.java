package com.whackon.witmed.department.dao;

import com.whackon.witmed.system.department.pojo.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>系统功能 - 系统人员部门信息数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface DepartmentDao {
    /**
     * <b>根据查询对象查询列表</b>
     * @param query
     * @return
     * @throws Exception
     */
    List<Department> findListByQuery(Department query) throws Exception;

    /**
     * <b>保存信息</b>
     * @param entity
     * @return
     * @throws Exception
     */
    int save(Department entity) throws Exception;

    /**
     * <b>修改信息</b>
     * @param entity
     * @return
     * @throws Exception
     */
    int update(Department entity) throws Exception;
}
