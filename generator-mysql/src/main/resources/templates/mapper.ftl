<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${beanName}Dao">
	<select id="findListByQuery" parameterType="${beanName}" resultMap="resultMap">
		select
		<#list colPropList as colProp>
		    ${tableAlias}.${colProp.colName}
		</#list>
		from
			${tableName} ${tableAlias}
		<where>
			<trim suffixOverrides="and">
            <#list colPropList as colProp>
                <if test="${colProp.propName} != null and ${colProp.propName} != ''">${tableAlias}.${colProp.colName}=<#noparse>#{</#noparse>${colProp.propName}<#noparse>}</#noparse> and </if>
			</#list>
			</trim>
		</where>
	</select>

	<insert id="save" parameterType="${beanName}">
		insert into ${tableName}(
			<trim suffixOverrides=",">
	        <#list colPropList as colProp>
		        <if test="${colProp.propName} != null and ${colProp.propName} != ''">${colProp.colName}, </if>
			</#list>
			</trim>
		) values(
			<trim suffixOverrides=",">
	        <#list colPropList as colProp>
				<if test="${colProp.propName} != null and ${colProp.propName} != ''"><#noparse>#{</#noparse>${colProp.propName}<#noparse>}</#noparse>, </if>
	        </#list>
			</trim>
		)
	</insert>

	<update id="update" parameterType="DataCode">
		update ${tableName}
		<set>
			<trim suffixOverrides=",">
            <#list colPropList as colProp>
				<if test="${colProp.propName} != null and ${colProp.propName} != ''">${colProp.colName}=<#noparse>#{</#noparse>${colProp.propName}<#noparse>}</#noparse>, </if>
            </#list>
			</trim>
		</set>
		<where>
			<trim suffixOverrides="and">
				<if test="id != null and id != ''">id=<#noparse>#{</#noparse>id<#noparse>}</#noparse> and </if>
			</trim>
		</where>
	</update>

	<resultMap id="resultMap" type="DataCode">
		<id property="id" javaType="java.lang.String" column="id"/>
    <#list colPropList as colProp>
	    <result property="${colProp.propName}" javaType="${colProp.propFullDataType}" column="${colProp.colName}"/>
	</#list>
	</resultMap>
</mapper>