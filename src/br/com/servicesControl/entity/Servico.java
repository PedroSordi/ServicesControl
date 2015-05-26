package br.com.servicesControl.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "servico")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1627456792912733906L;
	@DatabaseField(generatedId = true)
	private long id;
	@DatabaseField
	private String nome;
	@DatabaseField
	private String descricao;

	public Servico(long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Servico(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Servico() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return getId() + " " + getNome();
	}

}
