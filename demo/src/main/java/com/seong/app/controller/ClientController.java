package com.seong.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seong.app.model.client.ClientService;
import com.seong.app.model.client.ClientVO;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientServiceImpl;

	Logger logger = LoggerFactory.getLogger(ClientController.class);

	@RequestMapping("/main.do")
	public String select(Model model) {
		logger.info("select");
		model.addAttribute("datas", clientServiceImpl.select());
		return "main";
	}
	
	@RequestMapping("/insert.do")
	public String insert(ClientVO vo) {
		logger.info("insert");
		clientServiceImpl.insert(vo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(ClientVO vo) {
		System.out.println(vo);
		logger.info("delete");
		clientServiceImpl.delete(vo);
		return "redirect:main.do";
	}
	
	@RequestMapping("/update.do")
	public String update(ClientVO vo) {
		logger.info("update");
		clientServiceImpl.update(vo);
		return "redirect:main.do";
	}
}