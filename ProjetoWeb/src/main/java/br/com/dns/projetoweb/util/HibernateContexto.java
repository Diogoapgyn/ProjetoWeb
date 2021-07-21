package br.com.dns.projetoweb.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

}
