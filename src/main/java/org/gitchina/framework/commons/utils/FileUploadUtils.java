package org.gitchina.framework.commons.utils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {
	/**
	 * 全景相册子目录配置
	 */
	public static final String HOUSE_WEP_IMAGE_DIR = "images";

	/**
	 * 文件上传
	 * 
	 * @param template
	 *            文件
	 * @param templateFileName
	 *            文件名
	 * @param templateContentType
	 *            文件类型
	 * @param tarFileRootPath
	 *            文件根目录
	 * @param fileType
	 *            文件夹类型
	 * @return 文件相对路径
	 * @throws IOException
	 */
	public static String fileUpload(MultipartFile template, String templateFileName, String templateContentType, String tarFileRootPath,
			String fileType) throws IOException {
		String path = "";
		if (!template.isEmpty()) {
			path = copy(template, templateFileName, tarFileRootPath, fileType);
		}
		return path;
	}

	private static String copy(MultipartFile file, String fName, String tarFileRootPath, String fileType) {
		/**
		 * 存储路径
		 */
		StringBuilder path = new StringBuilder();

		path.append(tarFileRootPath);
		path.append("/");
		path.append(fileType);
		path.append("/");
		path.append(formatDateToString("yyyyMM", new Date()));
		path.append(formatDateToString("dd", new Date()));
		path.append("/");

		makeDirByPath(path.toString());

		/**
		 * 文件名
		 */
		StringBuilder fileName = new StringBuilder();

		fileName.append(formatDateToString("yyyyMMddhhmmss", new Date()));
		fileName.append(RandomNumTools.getSendPointNum());// 加文件随即数
		fileName.append(".");
		fileName.append(getExtension(fName));

		/**
		 * 文件存储全路径
		 */
		StringBuilder fileStorePath = new StringBuilder();
		fileStorePath.append(path);
		fileStorePath.append(fileName);

		String filePath = fileStorePath.toString();
		filePath = filePath.replace("\\", "/");
		try {
			file.transferTo(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 向data层传送的相对路径,最终会存入数据库
		String temp[] = filePath.split("/");
		StringBuffer str = new StringBuffer();
		str.append(temp[temp.length - 3]);
		str.append("/");
		str.append(temp[temp.length - 2]);
		str.append("/");
		str.append(temp[temp.length - 1]);
		return str.toString();
	}

	/**
	 * 根据文件路径创建文件夹，可以是多级目录
	 * 
	 * @param filePath
	 *            目录路径
	 */
	public static void makeDirByPath(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static String getFileSize(long fileSize) {
		/*
		 * 格式化计算结果，保留小数点两位
		 */
		DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();
		format.applyPattern("0.00");

		/*
		 * 获取文件的KB
		 */
		double kb = fileSize / 1024;
		if (fileSize > 0 && fileSize < 1024) {
			return format.format(kb) + " 字节";
		} else if (kb > 0 && kb < 1024) {
			return format.format(kb) + " KB";
		} else {
			return format.format(kb / 1024) + " MB";
		}
	}

	public static String formatDateToString(String pattern, Date date) {

		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		return sdf.format(date);
	}

	/**
	 * Return the extension portion of the file's name .
	 * 
	 * @see #getExtension
	 */
	public static String getExtension(File f) {
		return (f != null) ? getExtension(f.getName()) : "";
	}

	public static String getExtension(String filename) {
		return getExtension(filename, "");
	}

	public static String getExtension(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i + 1);
			}
		}
		return defExt;
	}

	public static String trimExtension(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');
			if ((i > -1) && (i < (filename.length()))) {
				return filename.substring(0, i);
			}
		}
		return filename;
	}

}
