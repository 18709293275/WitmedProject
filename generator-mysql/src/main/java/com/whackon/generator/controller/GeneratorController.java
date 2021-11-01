package com.whackon.generator.controller;

import com.whackon.generator.pojo.vo.GeneratorVO;
import com.whackon.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>生成器控制层类</b>
 * @author Arthur
 * @version 1.0.0
 */
@Controller("generatorController")
public class GeneratorController {
	@Autowired
	private GeneratorService generatorService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	/**
	 * <b>转发到首页面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/")
	public String forwardPage() throws Exception {
		return "generator_index";
	}

	/**
	 * <b>生成代码文件</b>
	 * @param generatorVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/generate")
	@ResponseBody
	public boolean createCodeFile(GeneratorVO generatorVO) throws Exception {
		try {
			generatorService.generateCodeFile(generatorVO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
