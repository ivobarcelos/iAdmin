package br.com.isoftlab.iadmin.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.isoftlab.iadmin.modelo.Empresa;

public class EmpresaDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public boolean existe(Empresa empresa) {
		boolean encontrado = false;
		try {
			Query query = manager.createQuery("select e from Empresa e where e.cnpj = :pCnpj").setParameter("pCnpj", empresa.getCnpj());
			encontrado = !query.getResultList().isEmpty();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return encontrado;
	}

	public Set<Empresa> pesquisaEmpresas(Empresa empresa) {
		List<Empresa> empresas= null;
		try {
			empresas = manager.createQuery("select e from empresa e where e.fantasia like :pFantasia",Empresa.class).setParameter("pFantasia", "%" + empresa.getFantasia() + "%").getResultList();
			System.out.println("passou");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return (Set<Empresa>) empresas;
	}
}