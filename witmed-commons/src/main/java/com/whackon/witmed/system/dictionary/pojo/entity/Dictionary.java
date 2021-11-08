package com.whackon.witmed.system.dictionary.pojo.entity;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import com.whackon.witmed.system.dictionary.pojo.vo.DictionaryVO;

import java.util.List;

/**
 * <b>系统功能 - 数据字典实体信息</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
public class Dictionary extends BaseEntity {
    private static final long serialVersionUID = 7172482097907332555L;
    private String id;                      // 主键
    private Dictionary parent;              // 上级字典信息
    private String name;                    // 字典名称
    private String code;                    // 字典编码
    private List<Dictionary> children;      // 下级字典列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dictionary getParent() {
        return parent;
    }

    public void setParent(Dictionary parent) {
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

    public List<Dictionary> getChildren() {
        return children;
    }

    public void setChildren(List<Dictionary> children) {
        this.children = children;
    }

    /**
     * <b>根据视图对象获得实体对象</b>
     * @param vo
     * @return
     */
    public static Dictionary getEntity(DictionaryVO vo) {
        // 创建实体对象
        Dictionary entity = new Dictionary();
        // 切换普通属性
        BeanUtil.copyProperties(vo, entity, false);
        // 获得关联属性
        if (vo.getParentVO() != null) {
            // 切换关联属性
            Dictionary parent = new Dictionary();
            BeanUtil.copyProperties(vo.getParentVO(), parent, false);
            entity.setParent(parent);
        }
        return entity;
    }
}
