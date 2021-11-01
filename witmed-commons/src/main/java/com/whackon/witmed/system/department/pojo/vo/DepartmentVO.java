package com.whackon.witmed.system.department.pojo.vo;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.department.pojo.entity.Department;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <b>系统功能 - 系统人员部门视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统功能 - 系统人员部门视图信息")
public class DepartmentVO extends BaseVO {
    private static final long serialVersionUID = 4519967254510105491L;
    @ApiModelProperty(value = "主键")
    private String id;                      // 主键
    @ApiModelProperty(value = "上级部门信息")
    private DepartmentVO parentVO;          // 上级部门信息
    @ApiModelProperty(value = "部门名称")
    private String name;                    // 部门名称
    @ApiModelProperty(value = "部门编码")
    private String code;                    // 部门编码
    @ApiModelProperty(value = "下级部门列表")
    private List<DepartmentVO> childrenVO; // 下级部门列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DepartmentVO getParentVO() {
        return parentVO;
    }

    public void setParentVO(DepartmentVO parentVO) {
        this.parentVO = parentVO;
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

    public List<DepartmentVO> getChildrenVO() {
        return childrenVO;
    }

    public void setChildrenVO(List<DepartmentVO> childrenVO) {
        this.childrenVO = childrenVO;
    }

    /**
     * <b>通过实体对象获得视图对象</b>
     * @param entity
     * @return
     */
    public static DepartmentVO getVO(Department entity) {
        // 创建视图对象
        DepartmentVO vo = new DepartmentVO();
        // 切换普通属性
        BeanUtil.copyProperties(entity, vo, false);
        // 获得关联属性
        if (entity.getParent() != null) {
            // 切换关联属性
            DepartmentVO parentVO = new DepartmentVO();
            BeanUtil.copyProperties(entity.getParent(), parentVO, false);
            vo.setParentVO(parentVO);
        }
        return vo;
    }
}
