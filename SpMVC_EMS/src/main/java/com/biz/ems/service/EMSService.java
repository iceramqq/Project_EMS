package com.biz.ems.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.model.EMSVO;

public interface EMSService {

	public List<EMSVO> selectAll();
	public void insert(EMSVO emsVO, MultipartFile file1,MultipartFile file2);
	public EMSVO findBySeq(long long_id);
	public int delete(long long_seq);
	public void update(EMSVO emsVO, MultipartFile file1,MultipartFile file2);
}
