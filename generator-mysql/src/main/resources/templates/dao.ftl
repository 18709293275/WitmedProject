import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <b></b>
* @author Arthur
* @version 1.0.0
*/
@Repository
public interface ${beanName}Dao {
	/**
	* <b>根据查询对象查询列表</b>
	* @param query
	* @return
	* @throws Exception
	*/
	List<${beanName}> findListByQuery(${beanName} query) throws Exception;

	/**
	* <b>保存对象信息</b>
	* @param entity
	* @return
	* @throws Exception
	*/
	int save(${beanName} entity) throws Exception;

	/**
	* <b>修改对象信息</b>
	* @param entity
	* @return
	* @throws Exception
	*/
	int update(${beanName} entity) throws Exception;
}