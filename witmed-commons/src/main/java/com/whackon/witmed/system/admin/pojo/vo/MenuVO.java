package com.whackon.witmed.system.admin.pojo.vo;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.admin.pojo.entity.Menu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <b>系统功能 - 系统菜单视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统功能 - 系统菜单视图信息")
public class MenuVO extends BaseVO {
    private static final long serialVersionUID = -1629398658391223735L;
    @ApiModelProperty(value = "主键")
    private String id;                      // 主键
    @ApiModelProperty(value = "上级菜单")
    private MenuVO parentVO;                // 上级菜单
    @ApiModelProperty(value = "菜单名称")
    private String text;                    // 菜单名称
    @ApiModelProperty(value = "操作连接地址")
    private String url;                     // 操作连接地址
    @ApiModelProperty(value = "菜单图标")
    private String icon;                    // 菜单图标
    @ApiModelProperty(value = "菜单顺序")
    private Integer sort;                   // 菜单顺序
    @ApiModelProperty(value = "下级菜单列表")
    private List<MenuVO> childrenVO;        // 下级菜单列表
    @ApiModelProperty(value = "对应角色列表")
    private List<RoleVO> roleVOList;        // 对应角色列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MenuVO getParentVO() {
        return parentVO;
    }

    public void setParentVO(MenuVO parentVO) {
        this.parentVO = parentVO;
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

    public List<MenuVO> getChildrenVO() {
        return childrenVO;
    }

    public void setChildrenVO(List<MenuVO> childrenVO) {
        this.childrenVO = childrenVO;
    }

    public List<RoleVO> getRoleVOList() {
        return roleVOList;
    }

    public void setRoleVOList(List<RoleVO> roleVOList) {
        this.roleVOList = roleVOList;
    }

    /**
     * <b>通过实体对象获得视图对象</b>
     * @param entity
     * @return
     */
    public static MenuVO getVO(Menu entity) {
        // 创建视图对象
        MenuVO vo = new MenuVO();
        // 切换普通属性
        BeanUtil.copyProperties(entity, vo, false);
        // 获得关联属性
        if (entity.getParent() != null) {
            // 切换关联属性
            MenuVO parentVO = new MenuVO();
            BeanUtil.copyProperties(entity.getParent(), parentVO, false);
            vo.setParentVO(parentVO);
        }
        return vo;
    }
}
