package com.millery.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.millery.mapper.UserMapper;
import com.millery.services.UserDaoService;


/**
 * 文件保存处理
 * @author Administrator
 *
 */
public class UploadFileUtil {
	public static String  creatFileName(String mime) {
		String fileName = UUID.randomUUID() + "." + mime.split("/")[1];
		return fileName;
	}
	/**
	 * 文件保存操作
	 * @param srcFile 上传原始文件数据输入流
	 * @param destFile 保存路径
	 * @return 成功返回true  反之 false
	 */
	public static boolean save(InputStream inputStream,File destFile) {
		boolean flag = false;
		OutputStream outputStream = null;
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
		try {
			outputStream = new FileOutputStream(destFile);
			byte data [] = new byte [2048];
			int temp = 0;
			while ((temp = inputStream.read(data)) != -1) {
				outputStream.write(data,0,temp);
			}
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
		
	}
}
