package br.com.dns.projetoweb.dao;

import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.dns.projetoweb.util.HibernateUtil;

public class GenericDao<Entidade> {
	
	public Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			//Transação começa
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			//Transacao termina
			transacao.commit();
		} catch (RuntimeException erro) {
			//Transacao foi aberta,for null deu problema
			if(transacao!=null) {
				transacao.rollback();
			}
			throw erro;
		}
		finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade>listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade>listar(String campoOrdenado){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.addOrder(Order.desc(campoOrdenado));
			List<Entidade> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			//idEq pega o valor do CODIGO que usuario digitou e compara com chave primaria
			consulta.add(Restrictions.idEq(codigo));
			//uniqueResult retorna somente um valor
			Entidade resultado = (Entidade)consulta.uniqueResult();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade>listarEnt(Date entrada){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			
			SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");  		   
			String result = out.format(entrada);
			
			
			consulta.addOrder(Order.desc(result));
			List<Entidade> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	
	
	
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			//Transação começa
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			//Transacao termina
			transacao.commit();
		} catch (RuntimeException erro) {
			//Transacao foi aberta,for null deu problema
			if(transacao!=null) {
				transacao.rollback();
			}
			throw erro;
		}
		finally {
			sessao.close();
		}
	}
	
	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			//Transação começa
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			//Transacao termina
			transacao.commit();
		} catch (RuntimeException erro) {
			//Transacao foi aberta,for null deu problema
			if(transacao!=null) {
				transacao.rollback();
			}
			throw erro;
		}
		finally {
			sessao.close();
		}
	}
	
	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			//Transação começa
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			//Transacao termina
			transacao.commit();
		} catch (RuntimeException erro) {
			//Transacao foi aberta,for null deu problema
			if(transacao!=null) {
				transacao.rollback();
			}
			throw erro;
		}
		finally {
			sessao.close();
		}
	}
	
	
	
}
