package com.biz.ems.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.model.EMSVO;

public interface EMSService {

	public List<EMSVO> selectAll();
	public void insert(EMSVO emsVO);
	public void insert(EMSVO emsVO,MultipartFile file);
	public List<String> insert(EMSVO emsVO, MultipartHttpServletRequest files);
	public EMSVO findBySeq(long long_seq);
	public int delete(long long_seq);
}
