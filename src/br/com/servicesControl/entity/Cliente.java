package br.com.servicesControl.entity;

import java.io.Serializable;
import java.util.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = -7616556808131544088L;
	@DatabaseField(generatedId = true)
	private long id;
	@DatabaseField
	private String nome;
	@DatabaseField
	private String cpf;
	@DatabaseField
	private String telefone;
//	@ForeignCollectionField(eager = true)
//	private Collection<Pedido> pedidos;

	public Cliente(String nome) {
		this.nome = nome;
	}

	public Cliente(long id, String nome, String cpf, String telefone,
			Collection<Pedido> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
//		this.pedidos = pedidos;
	}
	

	public Cliente(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public Cliente() {
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

//	public Collection<Pedido> getPedidos() {
//		return pedidos;
//	}
//
//	public void setPedidos(Collection<Pedido> pedidos) {
//		this.pedidos = pedidos;
//	}

	@Override
	public String toString() {
		return getId() + " - " + getNome();
	}
}
