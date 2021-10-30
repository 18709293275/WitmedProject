package com.whackon.witmed.system.datacode.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.datacode.pojo.entity.DataCodeCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

/**
 * <b>系统功能 - 数据编码功能 - 数据代码类别信息视图</b>
 * @author He'l'lo'World
 * @version 1.0.0
 */
@ApiModel("数据代码类别信息视图")
public class DataCodeCategoryVO extends BaseVO {
	private static final long serialVersionUID = 5148414514961602355L;
	@ApiModelProperty(name = "主键")
	private String id;                      // 主键
	@ApiModelProperty(name = "名称")
	private String name;                    // 名称
	@ApiModelProperty(name = "编码")
	private String code;                    // 编码

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
	 * <b>根据实体对象获得视图对象</b>
	 * @param entity
	 * @return
	 */
	public static DataCodeCategoryVO getVOFromEntity(DataCodeCategory entity) {
		// 创建视图对象
		DataCodeCategoryVO vo = new DataCodeCategoryVO();
		if (entity != null) {
			BeanUtils.copyProperties(entity, vo);
			// 切换所有的继承属性
			vo.setStatus(entity.getStatus());
			vo.setCreateUser(entity.getCreateUser());
			vo.setCreateTime(entity.getCreateTime());
			vo.setUpdateUser(entity.getUpdateUser());
			vo.setUpdateTime(entity.getUpdateTime());
		}
		return vo;
	}
}
