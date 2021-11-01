<#if hasDate>
import java.util.Date;
</#if>

/**
* <b>${tableComment}实体信息</b>
* @author Arthur
* @version 1.0.0
*/
public class ${beanName} {
<#list colPropList as colProp>
    private ${colProp.propShortDataType} ${colProp.propName};                      // ${colProp.colComment}
</#list>

	public static ${beanName} getEntityFromVO(${beanName}VO vo) {
		// 将视图属性切换为实体属性
		${beanName} entity = new ${beanName}();

	<#list colPropList as colProp>
	    entity.${colProp.setterMethodName}(vo.${colProp.getterMethodName}());
	</#list>
		return entity;
	}
}