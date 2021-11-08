package com.whackon.witmed.system.admin.pojo.vo;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.admin.pojo.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <b>系统功能 - 系统人员角色视图信息</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统功能 - 系统人员角色视图信息")
public class RoleVO extends BaseVO {
    private static final long serialVersionUID = -8891884516513232086L;
    @ApiModelProperty(value = "主键")
    private String id;                      // 主键
    @ApiModelProperty(value = "角色名称")
    private String name;                    // 角色名称
    @ApiModelProperty(value = "角色编码")
    private String code;                    // 角色编码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    /**
     * <b>通过实体对象获得视图对象</b>
     * @param entity
     * @return
     */
    public static RoleVO getVO(Role entity) {
        // 创建视图对象
        RoleVO vo = new RoleVO();
        // 切换普通属性
        BeanUtil.copyProperties(entity, vo, false);
        return vo;
    }
}
