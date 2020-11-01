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
		log.debug("update 요청데이터 {}", emsVO.toString());

		// 1. update 할 데이터의 id값을 추출
		long id = emsVO.getId();
		// 2. DB에 저장된 데이터를 id값으로 select
		EMSVO emsOldVO = emsDao.findBySeq(id);

		boolean file1_ex = file1.getOriginalFilename().isEmpty();
		// 3. upload된
		// 3-1. upload된 file1 있으면
		if (!file1_ex) {
			// 3-2 파일을 서버 저장소에 저장하고 파일이름 추출
			String file_1_Name = fileService.fileUp(file1);
			// 3-3 DB에 저장된 데이터에 파일이름이 있는지 검사
			if (emsOldVO.getS_file1() != null && !emsOldVO.getS_file1().isEmpty()) {
				// 3-4 있으면 서버에서 파일을 삭제
				fileService.fileDelete(emsOldVO.getS_file1());
			}
			// 3-5 새로변경된 파일이름을 vo에 저장하여 update 준비
			emsVO.setS_file1(file_1_Name);
			// 3-6 upload된 파일이 없으면
		} else if (file1_ex) {
			// 3-7 DB에서 추출한 vo에서 파일이름을 저장하여
			emsVO.setS_file1(emsOldVO.getS_file1());
		}

		boolean file2_ex = file1.getOriginalFilename().isEmpty();
		// 4. upload된
		if (!file2_ex) {
			String file_2_Name = fileService.fileUp(file2);
			if (emsOldVO.getS_file2() != null && !emsOldVO.getS_file2().isEmpty()) {
				fileService.fileDelete(emsOldVO.getS_file2());
			}
			emsVO.setS_file2(file_2_Name);
		} else if (file2_ex) {
			emsVO.setS_file2(emsOldVO.getS_file2());
		}

		int ret = emsDao.update(emsVO);
		if (ret > 0) {
			log.debug("업데이트된 데이터 개수 {}", ret);
		}

//		String fileName1 = fileService.fileUp(file1);
//		String fileName2 = fileService.fileUp(file2);
//		emsVO.setS_file1(fileName1);
//		emsVO.setS_file2(fileName2);
//		emsDao.update(emsVO);

	}

}
