package br.com.isoftlab.iadmin.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.isoftlab.iadmin.modelo.GrupoEmpresas;

public class GrupoEmpresasDao implements Serializable {
	
	private static final long serialVersionUID = -3563779878748959967L;

	@Inject
	private EntityManager manager;

	public void salvar(GrupoEmpresas grupoEmpresa){
		manager.getTransaction().begin();
		manager.merge(grupoEmpresa);
		manager.getTransaction().commit();
	}
	
	public void excluir(GrupoEmpresas grupoEmpresas){
		GrupoEmpresas grupoEmpresasExcluir = getById(grupoEmpresas);
		manager.getTransaction().begin();
		manager.remove(grupoEmpresasExcluir);
		manager.getTransaction().commit();
	}
	
	public boolean hasEmpresaInGrupoEmpresas(GrupoEmpresas grupoEmpresas){
		GrupoEmpresas grupoEmpresaValida = getById(grupoEmpresas);
		return (grupoEmpresaValida.getEmpresas().size() == 0 ? false : true );
	}
	
	public GrupoEmpresas getById(GrupoEmpresas grupoEmpresas){
		return  manager.find(GrupoEmpresas.class, grupoEmpresas.getId());
	}
	
	public List<GrupoEmpresas> listaTodosGrupos(){
		List<GrupoEmpresas> listaGrupoEmpresas = null;
		try {//select ge from grupoEmpresas ge left join fetch ge.empresas
			listaGrupoEmpresas = manager.createQuery("from grupoEmpresas",GrupoEmpresas.class).getResultList();

		} catch (Exception e) {
			listaGrupoEmpresas = null;
			System.out.println(e.getMessage());
		}
		return listaGrupoEmpresas;
	}
	
	public GrupoEmpresas buscaGrupoEmpresaPorCNPJ(String cnpj){
		GrupoEmpresas grupoEmpresas = null;
		try {
			TypedQuery<GrupoEmpresas> tq = manager.createQuery("select ge from GrupoEmpresas ge where ge.cnpj = :pCnpj",GrupoEmpresas.class).setParameter("pCnpj", cnpj);
			grupoEmpresas = tq.getSingleResult();
			
		} catch (Exception e) {
			grupoEmpresas = null;
			System.out.println(e.getMessage());
		}
		return grupoEmpresas;
	}
	
}
