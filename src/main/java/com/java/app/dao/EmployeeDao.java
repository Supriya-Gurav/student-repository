package com.java.app.dao;

import java.util.List;
import java.util.Optional;

import com.java.app.beans.EmpBean;
import com.java.app.entities.Employee;

public interface EmployeeDao 
{
	public String saveEmployee(Employee entity);
	public List<Employee> getListOfEmps();
	public String deleteEmployee(int empId);
	public EmpBean editEmployee(int empId);
	
}
