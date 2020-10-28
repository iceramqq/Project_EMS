package com.biz.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.model.EMSVO;
import com.biz.ems.service.EMSService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/ems")
public class EMSController {

	@Autowired
	@Qualifier("emsServiceV1")
	private EMSService emsService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list(Model model) {
		
		List<EMSVO> emsList = emsService.selectAll();
		model.addAttribute("emsList",emsList);
		return "/ems/list";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write() {
		return "/ems/write";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(EMSVO emsVO,@RequestParam(name = "file1",required = false) MultipartFile file1, MultipartFile file2) {
		
		emsService.insert(emsVO, file1, file2);
		return "redirect:/ems/list";
	
	}
	
	
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String detail(@PathVariable("id") String id, Model model) {
		
		long long_id = Long.valueOf(id);
		EMSVO emsVO = emsService.findBySeq(long_id);
		
		model.addAttribute("emsVO",emsVO);
		return "/ems/detail";
	}
	
	@RequestMapping(value = "/{id}/{url}",method = RequestMethod.GET)
	public String update(@PathVariable("id") String id,@PathVariable("url") String url, Model model) {		
		long long_seq = Long.valueOf(id);
		String ret_url = "redirect:/ems/list";
		
		if(url.equalsIgnoreCase("DELETE")) {
			emsService.delete(long_seq);
		} else if (url.equalsIgnoreCase("UPDATE")) {
			model.addAttribute("emsVO",emsService.findBySeq(long_seq));
			ret_url = "/ems/write";
		}
				
		return ret_url;
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(EMSVO emsVO, @RequestParam(name = "file1",required = false) MultipartFile file1, MultipartFile file2) {
		
		emsService.update(emsVO, file1, file2);
		return "redirect:/ems/list";
	
	}
	
}
