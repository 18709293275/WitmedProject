package com.whackon.generator.service.impl;

import com.whackon.generator.dao.GeneratorDao;
import com.whackon.generator.pojo.entity.TableBean;
import com.whackon.generator.pojo.vo.GeneratorVO;
import com.whackon.generator.service.GeneratorService;
import com.whackon.generator.util.ConnectionUtil;
import com.whackon.generator.util.FileUtil;
import com.whackon.generator.util.FreemarkerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.sql.Connection;
import java.util.List;

/**
 * <b>生成器业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 */
@Component("generatorService")
public class GeneratorServiceImpl implements GeneratorService {
	@Autowired
	private GeneratorDao generatorDao;

	/**
	 * <b>根据用户信息生成代码文件</b>
	 * @param generatorVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean generateCodeFile(GeneratorVO generatorVO) throws Exception {
		// 获得数据库连接对象
		Connection connection = ConnectionUtil.getConnection(generatorVO.getDbIP(), generatorVO.getDbPort()
				, generatorVO.getDbName(), generatorVO.getDbUser(), generatorVO.getDbPassword());
		// 查询数据库信息
		List<TableBean> tableBeanList = generatorDao.findTableBeanListByDBName(generatorVO.getDbName(), connection);
		// 循环数据库表信息，生成相关文件
		for (TableBean tableBean : tableBeanList) {
			// 生成实体类文件
			FileUtil.createFolder(generatorVO.getOutFolderPath() + File.separator + "entity");
			File entityFile = FileUtil.createFile(generatorVO.getOutFolderPath()
					+ File.separator + "entity" + File.separator + tableBean.getBeanName() + ".java");
			FreemarkerUtil.generateCodeFile(tableBean, entityFile, "entity");

			// 生成视图类文件
			FileUtil.createFolder(generatorVO.getOutFolderPath() + File.separator + "vo");
			File voFile = FileUtil.createFile(generatorVO.getOutFolderPath()
					+ File.separator + "vo" + File.separator + tableBean.getBeanName() + "VO.java");
			FreemarkerUtil.generateCodeFile(tableBean, voFile, "vo");

			// 生成 DAO 接口文件
			FileUtil.createFolder(generatorVO.getOutFolderPath() + File.separator + "dao");
			File daoFile = FileUtil.createFile(generatorVO.getOutFolderPath()
					+ File.separator + "dao" + File.separator + tableBean.getBeanName() + "Dao.java");
			FreemarkerUtil.generateCodeFile(tableBean, daoFile, "dao");

			// 生成 Mapper 映射文件
			FileUtil.createFolder(generatorVO.getOutFolderPath() + File.separator + "mapper");
			File mapperFile = FileUtil.createFile(generatorVO.getOutFolderPath()
					+ File.separator + "mapper" + File.separator + tableBean.getBeanName() + ".Mapper.xml");
			FreemarkerUtil.generateCodeFile(tableBean, mapperFile, "mapper");
		}
		return true;
	}
}
