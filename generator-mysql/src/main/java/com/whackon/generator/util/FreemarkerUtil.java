package com.whackon.generator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * <b>Freemarker 工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
public class FreemarkerUtil {

	/**
	 * <b>根据用户参数、输出文件夹路径、输出文件和模板生成代码文件</b>
	 * @param param
	 * @param outFile
	 * @param templateName
	 * @return
	 */
	public static boolean generateCodeFile(Object param, File outFile, String templateName) {
		// 创建 Freemarker 的 Configuration 对象
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
		try {
			String templatePath = ResourceUtils.getURL("classpath:").getPath()
					+ SystemConstants.FREEMARKER_TEMPLATE_PATH;
			// 加载模板所在路径
			configuration.setDirectoryForTemplateLoading(new File(templatePath));
			// 设置编码格式为 UTF-8
			configuration.setDefaultEncoding("UTF-8");
			// 根据生成所使用的模板名称获得模板对象
			Template template = configuration.getTemplate(templateName + ".ftl");
			// 根据输出文件 File 对象，创建输出流
			BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
			// 生成代码文件
			template.process(param, bw);
			bw.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
