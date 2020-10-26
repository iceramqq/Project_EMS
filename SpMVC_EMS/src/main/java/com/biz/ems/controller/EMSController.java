package com.biz.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ems.service.EMSService;

@Controller
@RequestMapping(value = "/ems")
public class EMSController {

	@Autowired
	@Qualifier("emsServiceV1")
	private EMSService emsService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list() {
		return "/ems/list";
	}
}
