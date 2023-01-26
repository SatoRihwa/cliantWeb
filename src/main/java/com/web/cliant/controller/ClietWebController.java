package com.web.cliant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.cliant.service.EmployeeApiService;
import com.web.cliant.service.ProjectApiService;

@Controller
public class ClietWebController{
	@Autowired
	private EmployeeApiService es;
	@Autowired
	private ProjectApiService ps;
	
	// 初期画面表示
	@RequestMapping(value="/top")
	public String start(Model model) {
		return viewTop(model);
	}
	
	public String viewTop(Model model) {
		model.addAttribute("employeeList", es.getAllEmployee());
		model.addAttribute("projectList", ps.getAllProject());
		return "top";
	}
}
