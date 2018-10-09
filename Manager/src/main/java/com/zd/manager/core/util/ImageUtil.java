package com.zd.manager.core.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {
	/*** @Title: compressPic * @Description: 压缩图片,通过压缩图片质量，保持原图大小* @param  quality:0-1    * @return byte[] * @throws*/
	public static byte[] compressPic(byte[] imageByte,float quality) {
		byte[] inByte = null;
		try {
			ByteArrayInputStream byteInput = new ByteArrayInputStream(imageByte);
			Image img = ImageIO.read(byteInput);
			float newWidth = img.getWidth(null);
			float newHeight = img.getHeight(null);
			Image image = img.getScaledInstance((int) newWidth,(int) newHeight, Image.SCALE_SMOOTH);// 缩放图像
			BufferedImage tag = new BufferedImage((int) newWidth,(int) newHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = tag.createGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ByteArrayOutputStream out = new ByteArrayOutputStream(imageByte.length);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam jep=JPEGCodec.getDefaultJPEGEncodeParam(tag);/* 压缩质量 */
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
			inByte = out.toByteArray();
			out.close();
			} catch (IOException ex){
				ex.printStackTrace();
				}
		return inByte;
		}
}
