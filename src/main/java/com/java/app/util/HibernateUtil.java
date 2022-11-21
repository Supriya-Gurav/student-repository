package com.java.app.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateUtil 
{
	private HibernateUtil()
	{
		
	}
	
	public static void CleanResources(Session session,Transaction tr)
	{
		if(session!=null)
		{
			if(tr!=null)
			{
				session.flush();
				tr.commit();
			}
			session.close();
		}
	}
}
