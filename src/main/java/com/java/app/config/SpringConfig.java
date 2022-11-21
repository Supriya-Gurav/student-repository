package com.java.app.config;


import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.java.app.entities.Employee;

@Configuration
@ComponentScan(basePackages = "com.java.app.*")
public class SpringConfig 
{
	static
	{
		System.out.println("Spring Config loaded.....");
	}
	
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root123");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/spring_db");
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return basicDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getFactory()
	{
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setAnnotatedClasses(Employee.class);
		
		Properties prop=new Properties();
		prop.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect"); 
		prop.put(Environment.HBM2DDL_AUTO,"update");
		prop.put(Environment.SHOW_SQL,true);
		
		bean.setHibernateProperties(prop);
		return bean;
		
	}
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/pages/");	
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
	

}
