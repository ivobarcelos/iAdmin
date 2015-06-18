package br.com.isoftlab.iadmin.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.isoftlab.iadmin.modelo.Usuario;

public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public boolean existe(Usuario usuario) {
		boolean encontrado = false;
		try {
			Query query = manager.createQuery("select u from Usuario u where u.login = :pLogin and u.senha = :pSenha")
					.setParameter("pLogin", usuario.getLogin())
					.setParameter("pSenha", usuario.getSenha());

			encontrado = !query.getResultList().isEmpty();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		return encontrado;
	}
}