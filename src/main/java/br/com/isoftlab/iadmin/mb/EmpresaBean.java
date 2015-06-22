package br.com.isoftlab.iadmin.mb;

import java.io.Serializable;
import java.util.Set;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.isoftlab.iadmin.dao.EmpresaDao;
import br.com.isoftlab.iadmin.modelo.Empresa;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {

	public EmpresaBean(){}

	private static final long serialVersionUID = -77305045519197440L;
	
	@Inject
	private EmpresaDao empresaDao;
	
	@Inject
	private Empresa empresa;
	
	private Set<Empresa> empresasPesquisadas;
	
	public void pesquisarEmpresas(){
		this.empresasPesquisadas = empresaDao.pesquisaEmpresas(this.empresa);
	}
	
	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	public Set<Empresa> getEmpresasPesquisadas() {
		return empresasPesquisadas;
	}
	public void setEmpresasPesquisadas(Set<Empresa> empresasPesquisadas) {
		this.empresasPesquisadas = empresasPesquisadas;
	}
	
	
}
