package br.com.dns.projetoweb.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.dns.projetoweb.domain.Usuario;
import br.com.dns.projetoweb.util.HibernateUtil;

public class UsuarioDao extends GenericDao<Usuario> {
	
	public Usuario autenticar(String user,String senha) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.add(Restrictions.eq("user",user));
			
			SimpleHash hash = new SimpleHash("md5",senha);
			consulta.add(Restrictions.eq("senha",hash.toHex()));
			
			Usuario resultado = (Usuario) consulta.uniqueResult();
			return resultado;
		}catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
