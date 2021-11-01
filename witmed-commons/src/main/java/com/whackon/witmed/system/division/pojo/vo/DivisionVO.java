package com.whackon.witmed.system.division.pojo.vo;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.division.pojo.entity.Division;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <b>系统功能 - 行政区划视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统功能 - 行政区划视图信息")
public class DivisionVO extends BaseVO {
    private static final long serialVersionUID = 7380522596936138538L;
    @ApiModelProperty(value = "主键")
    private String id;                      // 主键
    @ApiModelProperty(value = "上级行政区区划")
    private DivisionVO parentVO;            // 上级行政区区划
    @ApiModelProperty(value = "区划名称")
    private String name;                    // 区划名称
    @ApiModelProperty(value = "行政区划编码")
    private String code;                    // 行政区划编码
    @ApiModelProperty(value = "下级行政区划列表")
    private List<DivisionVO> childrenVO;   // 下级行政区划列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DivisionVO getParentVO() {
        return parentVO;
    }

    public void setParentVO(DivisionVO parentVO) {
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

    public List<DivisionVO> getChildrenVO() {
        return childrenVO;
    }

    public void setChildrenVO(List<DivisionVO> childrenVO) {
        this.childrenVO = childrenVO;
    }

    /**
     * <b>通过实体对象获得视图对象</b>
     * @param entity
     * @return
     */
    public static DivisionVO getVO(Division entity) {
        // 创建视图对象
        DivisionVO vo = new DivisionVO();
        // 切换普通属性
        BeanUtil.copyProperties(entity, vo, false);
        // 获得关联属性
        if (entity.getParent() != null) {
            // 切换关联属性
            DivisionVO parentVO = new DivisionVO();
            BeanUtil.copyProperties(entity.getParent(), parentVO, false);
            vo.setParentVO(parentVO);
        }
        return vo;
    }
}
