package br.com.isoftlab.iadmin.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity(name="grupoEmpresas")
public class GrupoEmpresas implements Serializable{

	public GrupoEmpresas(){
		this.cnpj="";
		this.id=0;
		this.nomeGrupoEmpresa="";
		this.nomeProprietario="";
	}
	
	private static final long serialVersionUID = -3618248091967946339L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable=false,unique=true)
	private int		id;
	
	@NotEmpty
	@Column(name="nomeGrupoEmpresa",nullable=false,length=100)
	private	String	nomeGrupoEmpresa;
	
	@NotEmpty
	@CNPJ
	@Column(name="cnpj",nullable=false,length=18)
	private String	 			cnpj;	
	
	@NotEmpty
	@Column(name="nomeProprietario",nullable=false,length=100)
	private String	nomeProprietario;
	
	@OneToMany(mappedBy = "grupoEmpresa")
	private Set<Empresa> 	empresas;	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNomeGrupoEmpresa() {
		return nomeGrupoEmpresa;
	}
	public void setNomeGrupoEmpresa(String nomeGrupoEmpresa) {
		this.nomeGrupoEmpresa = nomeGrupoEmpresa;
	}
	
	public String getCnpj() {
		//cnpj=cnpj.replace(".", "");
		//cnpj=cnpj.replace("-", "");
		//cnpj=cnpj.replace("/", "");
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	
	public Set<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}
	
}
