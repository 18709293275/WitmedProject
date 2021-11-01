package com.whackon.generator.service;

import com.whackon.generator.pojo.vo.GeneratorVO;

/**
 * <b>生成器业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 */
public interface GeneratorService {
	/**
	 * <b>根据用户信息生成代码文件</b>
	 * @param generatorVO
	 * @return
	 * @throws Exception
	 */
	boolean generateCodeFile(GeneratorVO generatorVO) throws Exception;
}
