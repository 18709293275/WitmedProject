package com.whackon.witmed.system.dictionary.pojo.vo;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.dictionary.pojo.entity.Dictionary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <b>系统功能 - 数据字典视图信息</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统功能 - 数据字典视图信息")
public class DictionaryVO extends BaseVO {
    private static final long serialVersionUID = -7677675210793960839L;
    @ApiModelProperty(value = "主键")
    private String id;                      // 主键
    @ApiModelProperty(value = "上级字典信息")
    private DictionaryVO parentVO;          // 上级字典信息
    @ApiModelProperty(value = "字典名称")
    private String name;                    // 字典名称
    @ApiModelProperty(value = "字典编码")
    private String code;                    // 字典编码
    @ApiModelProperty(value = "下级字典列表")
    private List<DictionaryVO> childrenVO; // 下级字典列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DictionaryVO getParentVO() {
        return parentVO;
    }

    public void setParentVO(DictionaryVO parentVO) {
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

    public List<DictionaryVO> getChildrenVO() {
        return childrenVO;
    }

    public void setChildrenVO(List<DictionaryVO> childrenVO) {
        this.childrenVO = childrenVO;
    }

    /**
     * <b>通过实体对象获得视图对象</b>
     * @param entity
     * @return
     */
    public static DictionaryVO getVO(Dictionary entity) {
        // 创建视图对象
        DictionaryVO vo = new DictionaryVO();
        // 切换普通属性
        BeanUtil.copyProperties(entity, vo, false);
        // 获得关联属性
        if (entity.getParent() != null) {
            // 切换关联属性
            DictionaryVO parentVO = new DictionaryVO();
            BeanUtil.copyProperties(entity.getParent(), parentVO, false);
            vo.setParentVO(parentVO);
        }
        return vo;
    }
}
