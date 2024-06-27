package org.jsp.springEmployee.controller;

import org.jsp.springEmployee.dao.EmployeeDao;
import org.jsp.springEmployee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("register");
		modelAndView.addObject("emp", new Employee());
		return modelAndView;
	}
	
	@PostMapping("/save")
	@ResponseBody
	public String saveEmployee(@ModelAttribute(name="emp") Employee employee) {
		employee = employeeDao.saveEmployee(employee);
		return "<h2>Employee saved with id :"+employee.getId()+"</h2>";
	}
}
