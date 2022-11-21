package com.java.app.controller;

import java.util.HashMap;
import java.util.List;

import javax.print.DocFlavor.SERVICE_FORMATTED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.app.beans.EmpBean;
import com.java.app.entities.Employee;
import com.java.app.service.EmployeeService;

@Controller
public class EmployeeController 
{
	static
	{
		System.out.println("Employee controller loaded......");
	}
	
	@Autowired
	EmployeeService service;
	

	@RequestMapping(value = "/registration",method = RequestMethod.GET)
	public ModelAndView  showRegistrationPage() 
	{
		
		
		HashMap<String,Object> model = new HashMap<String, Object>();
		model.put("empBean", new EmpBean()); 
		
		return new ModelAndView("Add_Employee",model);
	}
	
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView  saveEmployeeInformation(@ModelAttribute("empBean") EmpBean emp)
	{
		System.out.println(emp);
		
		String message = service.addNewEmployee(emp);
		
		
		
		HashMap<String,Object> model = new HashMap<String, Object>();
		model.put("empBean", new Employee()); 
		model.put("result",message);
		
		if(message.equals("Duplicate Employee..!")) 
		{
			model.put("empBean", emp);
		}
		
		return new ModelAndView("Add_Employee",model);
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView listOfEmps()
	{
		HashMap<String,Object> model=new HashMap<String,Object>();
		model.put("empList", service.listEmployees());
		
		return new ModelAndView("show_list",model);
		
	}

	@RequestMapping(value = "/edit_Employee/{empId}",method = RequestMethod.GET)
	public ModelAndView fetchForEdit(@PathVariable("empId")int empId)
	{
		HashMap<String,Object> model=new HashMap<String,Object>();
		EmpBean empBean=service.editEmployee(empId);
		System.out.println("Id to edit"+empId);
		model.put("empBean", empBean);
		return new ModelAndView("Add_Employee",model);
	}

	
	@RequestMapping(value = "/delete_Employee/{empId}",method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("empId")int empId) 
	{
		HashMap<String,Object> model=new HashMap<String,Object>();
		service.deleteEmployeeById(empId);
		List<EmpBean> beans=service.listEmployees();
		model.put("empList", beans);
		return new ModelAndView("show_list",model);
	}
	
	
	
}
