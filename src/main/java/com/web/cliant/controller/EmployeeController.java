package com.web.cliant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.cliant.model.EmployeeDisp;
import com.web.cliant.service.EmployeeApiService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeApiService es;
	
	//　従業員追加処理
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public String employeeSubmit(Model model, @ModelAttribute EmployeeDisp employee) {
		es.addEmployee(employee);
		model.addAttribute("employee", employee);
		return "employee";
	}
}
