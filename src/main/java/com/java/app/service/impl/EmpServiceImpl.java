package com.java.app.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.app.beans.EmpBean;
import com.java.app.dao.EmployeeDao;
import com.java.app.entities.Employee;
import com.java.app.service.EmployeeService;


@Service
public class EmpServiceImpl implements EmployeeService
{
	static
	{
		System.out.println("Emplyee service Impl loaded..........");
	}

	@Autowired
	EmployeeDao daoImpl;
	
	public Employee beanToEntity(EmpBean bean)
	{
		Employee empEntity=new Employee();
		empEntity.setEmpName(bean.getEmpName());
		empEntity.setEmpEmail(bean.getEmpEmail());
		empEntity.setEmpSalary(bean.getEmpSalary());
		empEntity.setEmpAge(bean.getEmpAge());
		empEntity.setEmpAddress(bean.getEmpAddress());
		return empEntity;
	}
	
	
	public String addNewEmployee(EmpBean bean) {
		
		return daoImpl.saveEmployee(beanToEntity(bean));
	}

	
	//entity --> bean
	private EmpBean entityToBean(Employee emp) {
		EmpBean empBean = new EmpBean();
		empBean.setEmpAddress(emp.getEmpAddress());
		empBean.setEmpAge(emp.getEmpAge());
		empBean.setEmpEmail(emp.getEmpEmail());
		empBean.setEmpName(emp.getEmpName());
		empBean.setEmpSalary(emp.getEmpSalary());
		empBean.setEmpId(emp.getEmpId());
		return empBean;
	}


	public List<EmpBean> listEmployees() 
	{
		List<Employee> entities=daoImpl.getListOfEmps();
		List<EmpBean> beans=convertEntitiesToBeans(entities);
		return beans;
	}


	private List<EmpBean> convertEntitiesToBeans(List<Employee> entities)
	{
		List<EmpBean> beans=new ArrayList<EmpBean>();
		for(Employee emp:entities)
		{
			EmpBean bean=entityToBean(emp);
			beans.add(bean);
		}
		return beans;
	}


	@Override
	public String deleteEmployeeById(int empid) {
		return daoImpl.deleteEmployee(empid);
		
	}


	@Override
	public EmpBean editEmployee(int empId) {
		return daoImpl.editEmployee(empId);
		
		
	}
	
}
