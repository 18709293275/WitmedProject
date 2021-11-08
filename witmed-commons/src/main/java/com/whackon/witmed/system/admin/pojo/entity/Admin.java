package com.whackon.witmed.system.admin.pojo.entity;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.department.pojo.entity.Department;
import com.whackon.witmed.system.dictionary.pojo.entity.Dictionary;

/**
 * <b>系统功能 - 系统人员实体信息</b>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
public class Admin extends BaseEntity {
    private static final long serialVersionUID = 4226492550883944160L;
    private String id;                      // 主键
    private String name;                    // 姓名
    private String cellphone;               // 手机号码
    private String password;                // 登录密码：MD5 加密
    private String identity;                // 人员身份：0-行政人员，1-医护人员
    private Role role;                      // 人员职务
    private Department department;          // 所属部门
    private String idCard;                  // 身份证号码
    private Dictionary techPos;             // 专业技术职务
    private Dictionary eduBg;               // 学历
    private String major;                   // 所学专业
    private Dictionary techPosRank;         // 专业技术职务等级
    private Dictionary position;            // 职务

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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Dictionary getTechPos() {
        return techPos;
    }

    public void setTechPos(Dictionary techPos) {
        this.techPos = techPos;
    }

    public Dictionary getEduBg() {
        return eduBg;
    }

    public void setEduBg(Dictionary eduBg) {
        this.eduBg = eduBg;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Dictionary getTechPosRank() {
        return techPosRank;
    }

    public void setTechPosRank(Dictionary techPosRank) {
        this.techPosRank = techPosRank;
    }

    public Dictionary getPosition() {
        return position;
    }

    public void setPosition(Dictionary position) {
        this.position = position;
    }


    /**
     * <b>根据视图对象获得实体对象</b>
     * @param vo
     * @return
     */
    public static Admin getEntity(AdminVO vo) {
        // 创建实体对象
        Admin entity = new Admin();
        // 切换普通属性
        BeanUtil.copyProperties(vo, entity, false);
        // 获得关联属性
        if (vo.getRoleVO() != null) {
            // 切换关联属性
            Role role = new Role();
            BeanUtil.copyProperties(vo.getRoleVO(), role, false);
            entity.setRole(role);
        }
        if (vo.getDepartmentVO() != null) {
            Department department = new Department();
            BeanUtil.copyProperties(vo.getDepartmentVO(), department, false);
            entity.setDepartment(department);
        }
        if (vo.getTechPosVO() != null) {
            Dictionary techPos = new Dictionary();
            BeanUtil.copyProperties(vo.getTechPosVO(), techPos, false);
            entity.setTechPos(techPos);
        }
        if (vo.getEduBgVO() != null) {
            Dictionary eduBg = new Dictionary();
            BeanUtil.copyProperties(vo.getEduBgVO(), eduBg, false);
            entity.setEduBg(eduBg);
        }
        if (vo.getTechPosRankVO() != null) {
            Dictionary techPosRank = new Dictionary();
            BeanUtil.copyProperties(vo.getTechPosRankVO(), techPosRank, false);
            entity.setTechPosRank(techPosRank);
        }
        if (vo.getPositionVO() != null) {
            Dictionary position = new Dictionary();
            BeanUtil.copyProperties(vo.getPositionVO(), position, false);
            entity.setPosition(position);
        }
        return entity;
    }
}
