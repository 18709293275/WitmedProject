<#if hasDate>
	import java.util.Date;
</#if>

/**
* <b>${tableComment}视图信息</b>
* @author Arthur
* @version 1.0.0
*/
public class ${beanName}VO {
<#list colPropList as colProp>
	private ${colProp.propShortDataType} ${colProp.propName};                      // ${colProp.colComment}
</#list>

	public static ${beanName}VO getVOFromEntity(${beanName} entity) {
		// 将实体属性切换为视图属性
		${beanName}VO vo = new ${beanName}VO();

	<#list colPropList as colProp>
		vo.${colProp.setterMethodName}(entity.${colProp.getterMethodName}());
	</#list>
		return vo;
	}
}