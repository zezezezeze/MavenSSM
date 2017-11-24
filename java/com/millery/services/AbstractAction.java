package com.millery.services;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.web.multipart.MultipartFile;

import com.millery.util.file.UploadFileUtil;

public abstract class AbstractAction {
	/**
	 * 生成图片名称
	 * 
	 * @param photoFile
	 * @return
	 */
	public String creratFileName(MultipartFile photoFile) {
		if (photoFile.isEmpty()) {
			return "nophoto.png";
		} else {
			return UploadFileUtil.creatFileName(photoFile.getContentType());
		}
	}

	/**
	 * 进行文件的保存处理
	 * 
	 * @param photoFile
	 */
	public boolean saveFile(MultipartFile photoFile, String fileName,
			HttpServletRequest request) {
		String filePath = request.getServletContext().getRealPath(
				this.getFileUploadDir())
				+ fileName;
		if (!photoFile.isEmpty()) {
			try {
				return UploadFileUtil.save(photoFile.getInputStream(),
						new File(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * 保存上传文件路径，子类实现
	 */
	public abstract String getFileUploadDir();
}
