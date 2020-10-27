package com.biz.ems.service;

import org.springframework.web.multipart.MultipartFile;

public interface fileService {

	public String fileUp(MultipartFile file);
	public boolean fileDelete(String s_file1);
	
}
