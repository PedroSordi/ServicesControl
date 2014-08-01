package br.com.servicesControl.entity;

public class Funcionario {

	private String nome;
	private String cpf;
	private String telefone;
	private Cargo cargo;
	private String usuario;
	private String senha;

	public Funcionario(String nome, String cpf, String telefone, Cargo cargo,
			String usuario, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cargo = cargo;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Funcionario() {

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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Definir valorHora mão de obra

}
