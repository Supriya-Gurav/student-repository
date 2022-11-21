package com.java.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.app.beans.EmpBean;
import com.java.app.dao.EmployeeDao;
import com.java.app.entities.Employee;
import com.java.app.util.HibernateUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
	static
	{
		System.out.println("EmployeeDaoImpl loaded....");
	}

	
	@Autowired
	SessionFactory sessionfactory;
	
	public String saveEmployee(Employee entity)
	{
		Session session=null;
		Transaction tr=null;
		try
		{
			session=sessionfactory.openSession();
			tr=session.beginTransaction();
			
			Criteria cr=session.createCriteria(Employee.class);
			cr.add(Restrictions.eq("empEmail", entity.getEmpEmail()));
			if(cr.list().size()>0)
			{
				return "Duplicate Employee....";
			}
			session.save(entity);
			return "Employee Record saved.....";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Problem in add new employee");
		}
		finally
		{
			HibernateUtil.CleanResources(session, tr);
		}
		return "Insertion failed";
		
	}

	public List<Employee> getListOfEmps() {
		Session session=null;
		Transaction tr=null;
		try
		{
			session=sessionfactory.openSession();
			Criteria cr=session.createCriteria(Employee.class);
			return cr.list();
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			HibernateUtil.CleanResources(session, tr);
		}
		return null;
	}

	@Override
	public String deleteEmployee(int empId) {
		Session session=null;
		Transaction tr=null;
		try
		{
			session=sessionfactory.openSession();
			tr=session.beginTransaction();
			Employee emp=session.get(Employee.class, empId);
			if(emp.getEmpId()!=0)
			{
				session.delete(emp);
				return "Employee to the given Id Deleted....";
			}
			else
			{
				return "Employee to the given Id is not present...";
			}
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			HibernateUtil.CleanResources(session, tr);
		}
		return null;
		
	}

	@Override
	public EmpBean editEmployee(int empId) {
		
		Session session=null;
		Transaction tr=null;
		try
		{
			session=sessionfactory.openSession();
			tr=session.beginTransaction();
			Employee emp=session.get(Employee.class, empId);
			EmpBean bean=new EmpBean();
			bean.setEmpName(emp.getEmpName());
			bean.setEmpEmail(emp.getEmpEmail());
			bean.setEmpSalary(emp.getEmpSalary());
			bean.setEmpAge(emp.getEmpAge());
			bean.setEmpAddress(emp.getEmpAddress());
			return bean;
			
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			HibernateUtil.CleanResources(session, tr);
		}
		return null;
	}

	
}
