package com.java.app.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlConfig implements WebApplicationInitializer
{
	static {
		System.out.println("Web Application Started (WebXmlConfig)....");
	}
	
	public void onStartup(ServletContext container) throws ServletException 
	{
		//XmlWebApplicationContext context = new XmlWebApplicationContext();
        //context.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
    	AnnotationConfigWebApplicationContext context = 
    			new AnnotationConfigWebApplicationContext();
    	
    	context.register(SpringConfig.class);  
    	context.setServletContext(container);
        ServletRegistration.Dynamic dispatcher = container
          .addServlet("dispatcher", new DispatcherServlet(context));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/"); 
		
	}

}
