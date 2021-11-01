package com.whackon.witmed.system.admin.pojo.vo;

import cn.hutool.core.bean.BeanUtil;
import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.admin.pojo.entity.Admin;
import com.whackon.witmed.system.department.pojo.vo.DepartmentVO;
import com.whackon.witmed.system.dictionary.pojo.vo.DictionaryVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <b>系统功能 - 系统人员视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统功能 - 系统人员视图信息")
public class AdminVO extends BaseVO {
    private static final long serialVersionUID = 811957010974699686L;
    @ApiModelProperty(value = "主键")
    private String id;                      // 主键
    @ApiModelProperty(value = "姓名")
    private String name;                    // 姓名
    @ApiModelProperty(value = "手机号码")
    private String cellphone;               // 手机号码
    @ApiModelProperty(value = "登录密码：MD5 加密")
    private String password;                // 登录密码：MD5 加密
    @ApiModelProperty(value = "人员身份：0-行政人员，1-医护人员")
    private String identity;                // 人员身份：0-行政人员，1-医护人员
    @ApiModelProperty(value = "人员职务")
    private RoleVO roleVO;                  // 人员职务
    @ApiModelProperty(value = "所属部门")
    private DepartmentVO departmentVO;      // 所属部门
    @ApiModelProperty(value = "身份证号码")
    private String idCard;                  // 身份证号码
    @ApiModelProperty(value = "专业技术职务")
    private DictionaryVO techPosVO;         // 专业技术职务
    @ApiModelProperty(value = "学历")
    private DictionaryVO eduBgVO;           // 学历
    @ApiModelProperty(value = "所学专业")
    private String major;                   // 所学专业
    @ApiModelProperty(value = "专业技术职务等级")
    private DictionaryVO techPosRankVO;     // 专业技术职务等级
    @ApiModelProperty(value = "职务")
    private DictionaryVO positionVO;        // 职务

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

    public RoleVO getRoleVO() {
        return roleVO;
    }

    public void setRoleVO(RoleVO roleVO) {
        this.roleVO = roleVO;
    }

    public DepartmentVO getDepartmentVO() {
        return departmentVO;
    }

    public void setDepartmentVO(DepartmentVO departmentVO) {
        this.departmentVO = departmentVO;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public DictionaryVO getTechPosVO() {
        return techPosVO;
    }

    public void setTechPosVO(DictionaryVO techPosVO) {
        this.techPosVO = techPosVO;
    }

    public DictionaryVO getEduBgVO() {
        return eduBgVO;
    }

    public void setEduBgVO(DictionaryVO eduBgVO) {
        this.eduBgVO = eduBgVO;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public DictionaryVO getTechPosRankVO() {
        return techPosRankVO;
    }

    public void setTechPosRankVO(DictionaryVO techPosRankVO) {
        this.techPosRankVO = techPosRankVO;
    }

    public DictionaryVO getPositionVO() {
        return positionVO;
    }

    public void setPositionVO(DictionaryVO positionVO) {
        this.positionVO = positionVO;
    }

    /**
     * <b>根据视图对象获得实体对象</b>
     * @param vo
     * @return
     */
    public static AdminVO getVO(Admin entity) {
        // 创建实体对象
        AdminVO vo = new AdminVO();
        // 切换普通属性
        BeanUtil.copyProperties(entity, vo, false);
        // 获得关联属性
        if (entity.getRole() != null) {
            // 切换关联属性
            RoleVO roleVO = new RoleVO();
            BeanUtil.copyProperties(entity.getRole(), roleVO, false);
            vo.setRoleVO(roleVO);
        }
        if (entity.getDepartment() != null) {
            DepartmentVO departmentVO = new DepartmentVO();
            BeanUtil.copyProperties(entity.getDepartment(), departmentVO, false);
            vo.setDepartmentVO(departmentVO);
        }
        if (entity.getTechPos() != null) {
            DictionaryVO techPosVO = new DictionaryVO();
            BeanUtil.copyProperties(entity.getTechPos(), techPosVO, false);
            vo.setTechPosVO(techPosVO);
        }
        if (entity.getEduBg() != null) {
            DictionaryVO eduBgVO = new DictionaryVO();
            BeanUtil.copyProperties(entity.getEduBg(), eduBgVO, false);
            vo.setEduBgVO(eduBgVO);
        }
        if (entity.getTechPosRank() != null) {
            DictionaryVO techPosRankVO = new DictionaryVO();
            BeanUtil.copyProperties(entity.getEduBg(), techPosRankVO, false);
            vo.setTechPosRankVO(techPosRankVO);
        }
        if (entity.getPosition() != null) {
            DictionaryVO positionVO = new DictionaryVO();
            BeanUtil.copyProperties(entity.getPosition(), positionVO, false);
            vo.setPositionVO(positionVO);
        }
        return vo;
    }
}
