package br.com.isoftlab.iadmin.mb;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.isoftlab.iadmin.modelo.Usuario;

@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado(){
		return usuario != null;
	}

	public void deslogar() {
		this.usuario = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
