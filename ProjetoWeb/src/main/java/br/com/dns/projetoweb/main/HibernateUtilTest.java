package br.com.dns.projetoweb.main;

import org.hibernate.Session;

import br.com.dns.projetoweb.util.HibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();

	}

}
