package br.com.isoftlab.iadmin.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tipoEndereco")
public class TipoEndereco implements Serializable {

	public TipoEndereco(){}
	
	private static final long serialVersionUID = -354481884880132203L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique=true, nullable=false)
	private int			id;
	
	@Column(name="descricao", nullable=false,length=50)
	private String		descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
