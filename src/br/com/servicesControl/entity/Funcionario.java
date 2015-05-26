package br.com.servicesControl.entity;

import java.io.Serializable;
import java.util.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "funcionario")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 2283312618438568419L;
	@DatabaseField(generatedId = true)
	private long id;
	@DatabaseField
	private String nome;
	@DatabaseField
	private String cpf;
	@DatabaseField
	private String telefone;
	@DatabaseField
	private String cargo;
	@DatabaseField
	private String senha;

	// @ForeignCollectionField(eager = true)
	// private Collection<Pedido> pedidos;

	public Funcionario(long id, String nome, String cpf, String telefone,
			String cargo, String usuario, String senha,
			Collection<Pedido> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cargo = cargo;
		this.senha = senha;
		// this.pedidos = pedidos;
	}

	public Funcionario(String nome, String cpf, String telefone, String cargo,
			String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cargo = cargo;
		this.senha = senha;
	}

	public Funcionario() {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// public Collection<Pedido> getPedidos() {
	// return pedidos;
	// }

	// public void setPedidos(Collection<Pedido> pedidos) {
	// this.pedidos = pedidos;
	// }

	@Override
	public String toString() {
		return getNome() + " - " + getCargo();
	}
}
