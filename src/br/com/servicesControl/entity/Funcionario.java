package br.com.servicesControl.entity;

public class Funcionario extends Pessoa{
	
	private Cargo cargo;
	private String usuario;
	private String senha;
	
	public Funcionario(String nome, String cpf, String telefone, String usuario,
			String senha) {
		super(nome, cpf, telefone);
		this.usuario = usuario;
		this.senha = senha;
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
