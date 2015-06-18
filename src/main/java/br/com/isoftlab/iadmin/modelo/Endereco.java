package br.com.isoftlab.iadmin.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="endereco")
public class Endereco implements Serializable{

	public Endereco(){}
	
	private static final long serialVersionUID = -604168228830255524L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique=true, nullable=false)
	private int			id;
	
	@Column(name="cep", nullable=false)
	private String		cep;
	
	@Column(name="endereco", nullable=false,length=100)
	private String 		endereco;
	
	@Column(name="numero", nullable=false)
	private int			numero;
	
	@Column(name="complemento", nullable=true,length=200)
	private String		complemento;
	
	@Column(name="bairro", nullable=false,length=100)
	private String		bairro;
	
	@Column(name="cidade", nullable=false,length=100)
	private String 		cidade;
	
	@Column(name="estado", nullable=false,length=50)
	private String 		estado;
	
	@Column(name="uf", nullable=false,length=2)
	private	String		uf;
	
	@OneToOne(targetEntity = TipoEndereco.class)
	@JoinColumn(name="idTipoEndereco")
	private TipoEndereco tipoEndereco;
	
	@ManyToOne(targetEntity=Empresa.class)
	@JoinColumn(name="idEmpresa")
	private Empresa empresa;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	
}
