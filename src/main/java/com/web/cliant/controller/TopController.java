package com.web.cliant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.cliant.model.Employee;
import com.web.cliant.model.Project;
import com.web.cliant.service.EmployeeApiService;
@Controller
public class TopController {
	
	@Autowired
	private ClietWebController webServlet;
	@Autowired
	private EmployeeApiService es;
	
	// 従業員削除
	@GetMapping("/top/employee/{id}")
	public String deleteEmployee(@PathVariable String id, Model model) {
		es.deleteEmployee(id);
		return webServlet.viewTop(model);
	}
	
	// 従業員追加(詳細画面遷移)
	@GetMapping("/top/employee/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee";
	}
	
	// 従業員詳細(詳細画面遷移)
	@GetMapping("/top/employee/view/{id}")
	public String viewEmployee(@PathVariable String id, Model model) {
		Employee e = es.getEmployeeById(id);
		model.addAttribute("employee", e);
		return "employee";
	}
	
	// プロジェクト削除
	@GetMapping("/top/project/{id}")
	public String deleteProject(@PathVariable String id, Model model) {

		return webServlet.viewTop(model);
	}
	
	// プロジェクト員追加(詳細画面遷移)
	@GetMapping("/top/project/add")
	public String addProject(Model model) {
		model.addAttribute("project", new Project());
		return "project";
	}
	
	@GetMapping("/top/test")
	public void test(String id) {
		es.getEmployeeById("1");
	}
}
