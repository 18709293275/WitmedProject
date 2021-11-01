package com.whackon.witmed.system.division.pojo.entity;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import com.whackon.witmed.system.division.pojo.vo.DivisionVO;

import java.util.List;

/**
 * <b>系统功能 - 行政区划实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Division extends BaseEntity {
    private static final long serialVersionUID = 3945728722993461962L;
    private String id;                      // 主键
    private Division parent;                // 上级行政区区划
    private String name;                    // 区划名称
    private String code;                    // 行政区划编码
    private List<Division> children;        // 下级行政区划列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Division getParent() {
        return parent;
    }

    public void setParent(Division parent) {
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

    public List<Division> getChildren() {
        return children;
    }

    public void setChildren(List<Division> children) {
        this.children = children;
    }

    /**
     * <b>根据视图对象获得实体对象</b>
     * @param vo
     * @return
     */
    public static Division getEntity(DivisionVO vo) {
        // 创建实体对象
        Division entity = new Division();
        // 切换普通属性
        BeanUtil.copyProperties(vo, entity, false);
        // 获得关联属性
        if (vo.getParentVO() != null) {
            // 切换关联属性
            Division parent = new Division();
            BeanUtil.copyProperties(vo.getParentVO(), parent, false);
            entity.setParent(parent);
        }
        return entity;
    }
}
