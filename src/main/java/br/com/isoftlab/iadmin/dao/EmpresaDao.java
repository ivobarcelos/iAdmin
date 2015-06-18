package br.com.isoftlab.iadmin.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
}