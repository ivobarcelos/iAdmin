package br.com.isoftlab.iadmin.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="empresa")
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1735641861108296986L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="id",unique=true,nullable=false)
	private int 			id;
	
	@Column(name="razao",nullable=false,length=100)
	private String 			razao;
	
	@Column(name="fantasia",nullable=false,length=100)
	private String 			fantasia;

	@Column(name="cnpj",nullable=false,length=14)
	private String	 			cnpj;
	
	@Column(name="contato",nullable=false,length=100)
	private	String			contato;
	
	@ManyToOne
	@JoinColumn(name="idGrupoEmpresa")
	private GrupoEmpresas 	grupoEmpresa;
	
	@OneToMany(mappedBy = "empresa")
	private Set<Endereco> enderecos;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getFantasia() {
		return fantasia;
	}
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}

	public GrupoEmpresas getGrupoEmpresa() {
		return grupoEmpresa;
	}
	public void setGrupoEmpresa(GrupoEmpresas grupoEmpresa) {
		this.grupoEmpresa = grupoEmpresa;
	}
	
	public Set<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
}
