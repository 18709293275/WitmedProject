package com.whackon.witmed.system.department.pojo.entity;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import com.whackon.witmed.system.department.pojo.vo.DepartmentVO;

import java.util.List;

/**
 * <b>系统功能 - 系统人员部门实体信息</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
public class Department extends BaseEntity {
    private static final long serialVersionUID = 6530373033750852488L;
    private String id;                      // 主键
    private Department parent;              // 上级部门信息
    private String name;                    // 部门名称
    private String code;                    // 部门编码
    private List<Department> children;      // 下级部门列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    /**
     * <b>根据视图对象获得实体对象</b>
     * @param vo
     * @return
     */
    public static Department getEntity(DepartmentVO vo) {
        // 创建实体对象
        Department entity = new Department();
        // 切换普通属性
        BeanUtil.copyProperties(vo, entity, false);
        // 获得关联属性
        if (vo.getParentVO() != null) {
            // 切换关联属性
            Department parent = new Department();
            BeanUtil.copyProperties(vo.getParentVO(), parent, false);
            entity.setParent(parent);
        }
        return entity;
    }
}
