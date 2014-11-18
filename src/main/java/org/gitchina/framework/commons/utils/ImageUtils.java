package org.gitchina.framework.commons.utils;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.lang.StringUtils;

public class ImageUtils {
	public static final String EXTENSION_STRING = "png, jpg, jpeg, gif, bmp";
	static String[] imageArray = new String[] { "png", "jpg", "jpeg", "gif",
			"bmp" };

	public static boolean isImage(String filename) {
		if (StringUtils.isBlank(filename)) {
			return false;
		}

		for (String name : imageArray) {
			if (filename.endsWith(name.toLowerCase())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 获取图片的一些属性(宽高、图片类型)
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ImageProperties getImageProperties(InputStream is) {
		ImageProperties ip = new ImageProperties();
		try {
			ImageInputStream iis = ImageIO.createImageInputStream(is);
			iis.mark();
			Iterator iter = ImageIO.getImageReaders(iis);
			if (!iter.hasNext()) {
				ip.setImageType(null);
			} else {
				ImageReader reader = (ImageReader) iter.next();
				ip.setImageType(reader.getFormatName());
			}
			iis.reset();
			BufferedImage bi = ImageIO.read(iis);
			ip.setWidth(bi.getWidth());
			ip.setHeight(bi.getHeight());
		} catch (IOException e) {
			ip.setWidth(0);
			ip.setHeight(0);
			ip.setImageType(null);
		}
		return ip;
	}

	public static void main(String[] args) throws FileNotFoundException {
		ImageProperties is = ImageUtils.getImageProperties(new FileInputStream("C:\\Users\\Administrator\\Desktop\\QQ截图20140310131330.jpg"));
		
		System.out.println(is.toString());
	}
}