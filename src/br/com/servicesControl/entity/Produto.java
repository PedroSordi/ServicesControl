package br.com.servicesControl.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "produto")
public class Produto implements Serializable {
	public final static String ID_FIELD_NAME = "id";
	
	private static final long serialVersionUID = 763223848134270140L;
	@DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
	private long id;
	@DatabaseField
	private String nome;
	@DatabaseField
	private String descricao;
	@DatabaseField
	private String marca;
	@DatabaseField
	private double valorCusto;
	@DatabaseField
	private int quantidade;

	public Produto(long id, String nome, String descricao, String marca,
			double valorCusto, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.valorCusto = valorCusto;
		this.quantidade = quantidade;
	}
	
	

	public Produto(String nome, String descricao, String marca,
			double valorCusto, int quantidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.valorCusto = valorCusto;
		this.quantidade = quantidade;
	}

	public Produto() {
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	@Override
	public String toString() {
		return getId()+ " " + getNome();
	}

}
