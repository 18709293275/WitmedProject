package com.whackon.witmed.system.admin.pojo.entity;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import com.whackon.witmed.system.admin.pojo.vo.MenuVO;

import java.util.List;

/**
 * <b>系统功能 - 系统菜单实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Menu extends BaseEntity {
    private static final long serialVersionUID = 6494472229034048736L;
    private String id;                      // 主键
    private Menu parent;                    // 上级菜单
    private String text;                    // 菜单名称
    private String url;                     // 操作连接地址
    private String icon;                    // 菜单图标
    private Integer sort;                   // 菜单顺序
    private List<Menu> children;            // 下级菜单列表
    private List<Role> roleList;            // 对应角色列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    /**
     * <b>根据视图对象获得实体对象</b>
     * @param vo
     * @return
     */
    public static Menu getEntity(MenuVO vo) {
        // 创建实体对象
        Menu entity = new Menu();
        // 切换普通属性
        BeanUtil.copyProperties(vo, entity, false);
        // 获得关联属性
        if (vo.getParentVO() != null) {
            // 切换关联属性
            Menu parent = new Menu();
            BeanUtil.copyProperties(vo.getParentVO(), parent, false);
            entity.setParent(parent);
        }
        return entity;
    }
}
