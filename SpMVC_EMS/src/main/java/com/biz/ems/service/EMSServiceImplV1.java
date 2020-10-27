package com.biz.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.mapper.EMSDao;
import com.biz.ems.model.EMSVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("emsServiceV1")
public class EMSServiceImplV1 implements EMSService {

	@Autowired
	private EMSDao emsDao;

	@Autowired
	@Qualifier("fileServiceV1")
	private fileService fileService;

	@Override
	public List<EMSVO> selectAll() {
		// TODO Auto-generated method stub
		return emsDao.selectAll();
	}

	@Override
	public void insert(EMSVO emsVO, MultipartFile file1, MultipartFile file2) {

		String fileName1 = fileService.fileUp(file1);
		String fileName2 = fileService.fileUp(file2);
		emsVO.setS_file1(fileName1);
		emsVO.setS_file2(fileName2);
		log.debug(emsVO.toString());
		emsDao.insert(emsVO);
	}

	@Override
	public EMSVO findBySeq(long long_id) {
		// TODO Auto-generated method stub
		return emsDao.findBySeq(long_id);
	}

	@Override
	public int delete(long long_seq) {
		// TODO Auto-generated method stub
		EMSVO emsVO = emsDao.findBySeq(long_seq);

		String s_file1 = emsVO.getS_file1();
		String s_file2 = emsVO.getS_file2();
		if (s_file1 != null) {
			fileService.fileDelete(s_file1);
		}
		if (s_file2 != null) {
			fileService.fileDelete(s_file2);
		}
		return emsDao.delete(long_seq);
	}

	@Override
	public void update(EMSVO emsVO, MultipartFile file1, MultipartFile file2) {
		// TODO Auto-generated method stub
		
		String fileName1 = fileService.fileUp(file1);
		String fileName2 = fileService.fileUp(file2);
		emsVO.setS_file1(fileName1);
		emsVO.setS_file2(fileName2);
		emsDao.update(emsVO);
		
	}

}
