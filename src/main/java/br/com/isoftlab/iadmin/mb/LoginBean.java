package br.com.isoftlab.iadmin.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.isoftlab.iadmin.dao.UsuarioDao;
import br.com.isoftlab.iadmin.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	@Inject
	Event<Usuario> eventoLogin;

	private static final long serialVersionUID = -5129182164284875342L;
	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDao dao;

	@Inject
	private UsuarioLogadoBean usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String efetuaLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			usuarioLogado.logar(usuario);
			//eventoLogin.fire(usuario);
			
			FacesMessage mensagem = new FacesMessage("Usuário/senha Válidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, mensagem);
			
			return "/pages/main?faces-redirect=true";
		} else {
			FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "index";
		}
	}

	public String logout() {
		this.usuarioLogado.deslogar();
		return "index?faces-redirect=true";
	}

}
