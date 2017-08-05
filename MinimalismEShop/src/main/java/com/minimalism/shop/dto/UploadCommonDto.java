package com.minimalism.shop.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadCommonDto {
	private String description;
	
	private CommonsMultipartFile[] filePath;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommonsMultipartFile[] getFilePath() {
		return filePath;
	}

	public void setFilePath(CommonsMultipartFile[] filePath) {
		this.filePath = filePath;
	}
	
} 
