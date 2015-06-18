package br.com.isoftlab.iadmin.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.isoftlab.iadmin.modelo.Empresa;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {

	public EmpresaBean(){}

	private static final long serialVersionUID = -77305045519197440L;
	
	@Inject
	private Empresa empresa;
	
	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
