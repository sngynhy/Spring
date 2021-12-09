package com.seong.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seong.app.model.client.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientServiceImpl;

	Logger logger = LoggerFactory.getLogger(ClientController.class);

	@RequestMapping("/test.do")
	public String c_select(Model model){
		logger.info("들어옴?");
		model.addAttribute("datas", clientServiceImpl.c_selectDB());
		return "test";
	}
}