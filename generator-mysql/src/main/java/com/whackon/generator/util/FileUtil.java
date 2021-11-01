package com.whackon.generator.util;

import java.io.File;

/**
 * <b>文件操作工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
public class FileUtil {

	/**
	 * <b>根据目录路径创建目录 File 对象</b>
	 * @param folderPath
	 * @return
	 */
	public static File createFolder(String folderPath) {
		try {
			// 根据路径创建 File 对象
			File folder = new File(folderPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			return folder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <b>根据文件路径创建文件 File 对象</b>
	 * @param filePath
	 * @return
	 */
	public static File createFile(String filePath) {
		try {
			// 根据路径创建 File 对象
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
