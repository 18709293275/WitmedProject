package com.whackon.witmed.system.admin.pojo.entity;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import com.whackon.witmed.system.admin.pojo.vo.RoleVO;

/**
 * <b>系统功能 - 系统人员角色实体信息</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
public class Role extends BaseEntity {
    private static final long serialVersionUID = 3832012392097686144L;
    private String id;                      // 主键
    private String name;                    // 角色名称
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
     * <b>根据视图对象获得实体对象</b>
     * @param vo
     * @return
     */
    public static Role getEntity(RoleVO vo) {
        // 创建实体对象
        Role entity = new Role();
        // 切换普通属性
        BeanUtil.copyProperties(vo, entity, false);
        return entity;
    }
}
