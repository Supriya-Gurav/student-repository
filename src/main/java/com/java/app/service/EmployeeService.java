package com.java.app.service;

import java.util.List;


import com.java.app.beans.EmpBean;
import com.java.app.entities.Employee;

public interface EmployeeService 
{
	public String addNewEmployee(EmpBean bean);
	
	public List<EmpBean> listEmployees();

	public String deleteEmployeeById(int empId);
	
	public EmpBean editEmployee(int empId);
	
	
	
	
}
