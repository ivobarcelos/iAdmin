package br.com.isoftlab.iadmin.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.data.PageEvent;
import br.com.isoftlab.iadmin.dao.GrupoEmpresasDao;
import br.com.isoftlab.iadmin.modelo.Empresa;
import br.com.isoftlab.iadmin.modelo.GrupoEmpresas;
import br.com.isoftlab.iadmin.util.FacesMessages;

@Named
@ViewScoped
public class GrupoEmpresasBean implements Serializable {
	
	public GrupoEmpresasBean(){}
	
	private static final long serialVersionUID = -7085563415970273844L;

	@Inject
	private GrupoEmpresasDao grupoEmpresasDao;
	
	@Inject
	private GrupoEmpresas grupoEmpresasInclusaoEdicao = new GrupoEmpresas();

	@Inject
	private FacesMessages messages;
	
	private List<GrupoEmpresas> todosGruposEmpresas;//lista no datatable
	private GrupoEmpresas grupoEmpresaSelecionada;//controla a linha selecionada no datatable
	private Set<Empresa> empresasDoGrupo;// =grupoEmpresasInclusaoEdicao.getEmpresas();

	public void consultar(){
		todosGruposEmpresas = grupoEmpresasDao.listaTodosGrupos();
	}
	
	public void prepararInclusaoEdicao(){
		grupoEmpresasInclusaoEdicao = new GrupoEmpresas();
	}
	
	public void excluirGrupoEmpresas(){
		if ( grupoEmpresasDao.hasEmpresaInGrupoEmpresas(grupoEmpresaSelecionada) ){
			messages.info("Este Grupo possui empresas relacionadas, náo será possível excluir!!!");
		}else{
			grupoEmpresasDao.excluir(grupoEmpresaSelecionada);
			setGrupoEmpresaSelecionada(null);
			consultar();
			messages.info("Grupo excluido com sucesso");
		}
	}
	
	public void salvarGrupoEmpresas(){
		grupoEmpresasDao.salvar(grupoEmpresasInclusaoEdicao);
		
		consultar();
		
		messages.info("Grupo salvo com sucesso");
		setGrupoEmpresaSelecionada(null);
		RequestContext.getCurrentInstance().update(
			Arrays.asList("form-lista:messages-geral","form-lista:listaGrupo","form-lista:toolbar")
		);
	}
	
	public void desabilitaToolbar(PageEvent event){//quando se pagina o datatable seta o objeto para null para desabilitar a toolbar - evento atrelado a pagina xhtml
		setGrupoEmpresaSelecionada(null);
	}

	public List<GrupoEmpresas> getTodosGruposEmpresas() {
		return todosGruposEmpresas;
	}

	public GrupoEmpresas getGrupoEmpresaSelecionada() {
		return grupoEmpresaSelecionada;
	}
	public void setGrupoEmpresaSelecionada(GrupoEmpresas grupoEmpresaSelecionada) {
		this.grupoEmpresaSelecionada = grupoEmpresaSelecionada;
		
		if ( this.grupoEmpresaSelecionada == null){
			empresasDoGrupo = null;
		}else{
			if (this.grupoEmpresaSelecionada.getEmpresas().size() == 0 ){
				empresasDoGrupo = null;
			}else{
				setEmpresasDoGrupo(this.grupoEmpresaSelecionada.getEmpresas());
			}
		}
	}
	
	public GrupoEmpresas getGrupoEmpresasInclusaoEdicao() {
		return grupoEmpresasInclusaoEdicao;
	}
	public void setGrupoEmpresasInclusaoEdicao(GrupoEmpresas grupoEmpresasInclusaoEdicao) {
		this.grupoEmpresasInclusaoEdicao = grupoEmpresasInclusaoEdicao;
	}

	public Set<Empresa> getEmpresasDoGrupo() {
		return empresasDoGrupo;
	}
	public void setEmpresasDoGrupo(Set<Empresa> empresasDoGrupo) {
		this.empresasDoGrupo = empresasDoGrupo;
	}
	
	
}
